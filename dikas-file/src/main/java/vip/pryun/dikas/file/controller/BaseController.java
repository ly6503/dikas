package vip.pryun.dikas.file.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Validated
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /*protected UnifyUser getCurrentUser() {
        return getCurrentUser(true);
    }

    protected UnifyUser getCurrentUser(boolean required) {
        Object object = request.getUserPrincipal();
        if (object instanceof PhonePasswordAuthenticationToken) {
            Object details = ((PhonePasswordAuthenticationToken) object).getPrincipal();
            if (details instanceof UnifyUser) {
                return (UnifyUser) details;
            }
        }
        if (required) {
            throw new BizException(Msg.E40001);
        }
        return null;
    }*/

    /**
     * 根据service层的执行成功与失败生成对应的响应结果
     *
     * @param success service层操作是否成功
     * @param msg     错误信息
     * @return
     */
    protected Result<Boolean> newResult(Boolean success, Msg msg) {
        if (success) {
            return Result.success(null);
        } else {
            return Result.error(msg);
        }
    }

    /**
     * 将DTO,Bean转换为VO作为响应结果
     *
     * @param result  返回的结果
     * @param voClass
     * @return
     */
    protected <T, V> Result<V> newResult(T result, Class<V> voClass) {
        if (result == null) {
            return Result.success(null);
        }

        return Result.success(BeanMapper.map(result, voClass));
    }

    /**
     * 将List<DTO>,List<Bean>转换为VO作为响应结果
     *
     * @param resultList
     * @param voClass
     * @param <E>
     * @param <V>
     * @return
     */
    protected <E extends List, V> Result<List<V>> newResult(E resultList, Class<V> voClass) {
        if (CollectionUtils.isEmpty(resultList)) {
            return Result.success(new ArrayList<>());
        }

        Class srcClass = resultList.iterator().next().getClass();
        List<V> vos = BeanMapper.mapList(resultList, BeanMapper.getType(srcClass), BeanMapper.getType(voClass));

        return Result.success(vos);
    }

    /**
     * 将IPage<Bean>转换为IPage<VO>作为响应结果
     *
     * @param resultPage
     * @param voClass
     * @param <T>
     * @param <V>
     * @return
     */
    protected <T extends IPage, V> Result<IPage<V>> newResult(T resultPage, Class<V> voClass) {
        IPage<V> voPage = resultPage;

        if (CollectionUtils.isEmpty(voPage.getRecords())) {
            return Result.success(voPage);
        } else {
            List beans = voPage.getRecords();
            Class beanClass = beans.get(0).getClass();
            List<V> vos = BeanMapper.mapList(voPage.getRecords(), BeanMapper.getType(beanClass), BeanMapper.getType(voClass));
            voPage.setRecords(vos);

            return Result.success(voPage);
        }
    }

    /**
     * 创建分页对象
     *
     * @param <R> Bean类型
     * @return
     */
    public <R> Page<R> newPage(QueryParam queryParam) {
        return new Page<>(queryParam.getCurrent(), queryParam.getSize());
    }

}
