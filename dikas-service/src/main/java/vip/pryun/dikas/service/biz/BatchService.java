package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.aop.framework.AopContext;
import vip.pryun.dikas.common.mybatis.EFunction;
import vip.pryun.dikas.common.mybatis.annotation.transaction.ITransactional;
import vip.pryun.dikas.common.object.UnifyUser;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.common.util.bean.BeanUtils;
import vip.pryun.dikas.domain.BaseBean;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 扩展MP的ServiceImpl,继承该Service而不是ServiceImpl即可使用它的方法
 *
 * @author 59941
 * @date 2019/4/29 15:47
 */
public class BatchService<M extends BaseMapper<T>, T extends BaseBean> extends ServiceImpl<M, T> {

    /**
     * 如果当前要保存的数据集合中某些数据元素在数据库中存在,则修改数据库中对应的记录;如果不存在,则保存;如果数据库中存在但要保存的数据集合中不存在,就删除数据库中的那些记录。
     *
     * @param beans           要保存或更新的数据集合
     * @param wrapper         例如图片表中,需要用图片类型和引用id作为其他表的外键.那么Wrapper需要这样构造
     *                        <code>
     *                        <p>.eq(ImgBean::getType, imgBeans.get(0).getType())</p>
     *                        <p>.eq(ImgBean::getRefId, imgBeans.get(0).getRefId());</p>
     *                        </code>
     * @param propertyMappers 例如以bean的url属性判断该bean是否在数据库中存在,那么
     *                        <p><code>List<EFunction<**Bean, Object>> propertyMappers = Lists.newArrayList(**Bean::getUrl);</code></p>
     * @param unifyUser       登录用户
     */
    @ITransactional
    @Deprecated
    public void saveOrUpdateOrDelete(Collection<T> beans, LambdaQueryWrapper<T> wrapper, List<EFunction<T, Object>> propertyMappers, UnifyUser unifyUser) {
        if (CollectionUtils.isEmpty(propertyMappers)) {
            throw new IllegalArgumentException("propertyMappers size should be greater than 0");
        }

        LambdaQueryWrapper<T> originalWrapper = BeanMapper.deepClone(wrapper);

        // 构造每一个in(...)条件
        for (EFunction<T, Object> propertyMapper : propertyMappers) {
            Set<Object> in = beans.stream().map(propertyMapper).collect(Collectors.toSet());
            wrapper.in(propertyMapper, in);
        }

        BatchService<M, T> _this = (BatchService<M, T>) AopContext.currentProxy();
        // 查出要操作的数据在数据库中的对应数据
        List<T> dbList = _this.list(wrapper);

        // 数据库没有查到数据,则所有bean都应该保存
        if (CollectionUtils.isEmpty(dbList)) {
            BeanUtils.addEntryInfo(beans, unifyUser);
            _this.saveBatch(beans);
            return;
        }

        // 生成一个用于将dbList转换为dbMap的keyMapper
        EFunction<T, List<Object>> keyMapper = bean -> {
            List<Object> mapKey = new ArrayList<>(propertyMappers.size());
            for (EFunction<T, Object> propertyMapper : propertyMappers) {
                // 得到bean中用于判断该bean是否在数据库中存在的那些属性的属性值
                Object propertyValue = propertyMapper.apply(bean);
                mapKey.add(propertyValue);
            }

            return mapKey;
        };

        // dbList转dbMap,它的key用于标识bean是否在数据库中已存在,它的value用于按id进行批量更新
        Map<List<Object>, Long> dbMap = dbList.stream().collect(Collectors.toMap(
                keyMapper,
                BaseBean::getId));

        // 需要更新的bean
        List<T> updateBeans = Lists.newArrayList();
        // 需要插入的bean
        List<T> insertBeans = Lists.newArrayList();

        // 得到需要更新和插入的元素
        beans.forEach(bean -> {
            List<Object> mapKey = keyMapper.apply(bean);
            if (dbMap.containsKey(mapKey)) {
                // 用于按id批量更新
                Long id = dbMap.get(mapKey);
                bean.setId(id);

                BeanUtils.addUpdateInfo(bean, unifyUser);
                updateBeans.add(bean);
            } else {
                BeanUtils.addEntryInfo(bean, unifyUser);
                insertBeans.add(bean);
            }
        });

        // 删除时不需要删除的id
        List<Long> excludeIds = Lists.newArrayList();

        // 批量更新
        if (!CollectionUtils.isEmpty(updateBeans)) {
            _this.updateBatchById(updateBeans);

            excludeIds = updateBeans.stream().map(BaseBean::getId).collect(Collectors.toList());
        }

        // 删除时是否需要排除更新了的记录,必须判断excludeIds,否则会生成如下错误sql: in()
        if (!CollectionUtils.isEmpty(excludeIds)) {
            originalWrapper.notIn(BaseBean::getId, excludeIds);
        }
        _this.remove(originalWrapper);

        // 批量插入
        if (!CollectionUtils.isEmpty(insertBeans)) {
            _this.saveBatch(insertBeans);
        }
    }

    /**
     * 根据id属性判断要保存的数据是否在数据库中存在.<br/>
     * 如果当前要保存的数据集合中某些数据元素在数据库中存在,则修改数据库中对应的记录;如果不存在,则保存;如果数据库中存在但要保存的数据集合中不存在,就删除数据库中的那些记录。
     *
     * @param beans     要保存或更新的数据集合
     * @param wrapper   例如图片表中,需要用图片类型和引用id作为其他表的外键.那么Wrapper需要这样构造
     *                  <code>
     *                  <p>.eq(ImgBean::getType, imgBeans.get(0).getType())</p>
     *                  <p>.eq(ImgBean::getRefId, imgBeans.get(0).getRefId());</p>
     *                  </code>
     * @param unifyUser 登录用户
     */
    @ITransactional
    public void saveOrUpdateOrDeleteById(Collection<T> beans, LambdaQueryWrapper<T> wrapper, UnifyUser unifyUser) {
        // 需要更新的bean
        List<T> updateBeans = Lists.newArrayList();
        // 需要插入的bean
        List<T> insertBeans = Lists.newArrayList();

        beans.forEach(bean -> {
            if (bean.getId() != null) {
                BeanUtils.addUpdateInfo(bean, unifyUser);

                updateBeans.add(bean);
            } else {
                BeanUtils.addEntryInfo(bean, unifyUser);

                insertBeans.add(bean);
            }
        });

        BatchService<M, T> _this = (BatchService<M, T>) AopContext.currentProxy();

        // 删除时不需要删除的id
        List<Long> excludeIds = Lists.newArrayList();

        // 批量更新
        if (!CollectionUtils.isEmpty(updateBeans)) {
            _this.updateBatchById(updateBeans);

            excludeIds = updateBeans.stream().map(BaseBean::getId).collect(Collectors.toList());
        }

        // 删除时是否需要排除更新了的记录,必须判断excludeIds,否则会生成如下错误sql: in()
        if (!CollectionUtils.isEmpty(excludeIds)) {
            wrapper.notIn(BaseBean::getId, excludeIds);
        }
        _this.remove(wrapper);

        // 批量插入
        if (!CollectionUtils.isEmpty(insertBeans)) {
            _this.saveBatch(insertBeans);
        }
    }
}
