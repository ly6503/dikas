package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.object.UnifyUser;
import vip.pryun.dikas.common.util.bean.BeanUtils;
import vip.pryun.dikas.domain.RecruitBean;
import vip.pryun.dikas.persistence.dao.RecruitDao;
import vip.pryun.dikas.service.biz.IRecruitService;
import vip.pryun.dikas.service.enums.RecruitStatusEnum;

/**
 * <p>
 * 职务表 服务实现类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@Service
public class RecruitServiceImpl extends ServiceImpl<RecruitDao, RecruitBean> implements IRecruitService {

    @Override
    public Boolean saveRecruit(RecruitBean recruitBean) {
        QueryWrapper<RecruitBean> wrapper = new QueryWrapper<>();
        wrapper.eq("recruit_name", recruitBean.getRecruitName());
        RecruitBean one = getOne(wrapper);
        if (one != null) {
            return false;
        }
        BeanUtils.addEntryInfo(recruitBean, new UnifyUser(0L, "robot"));
        return save(recruitBean);
    }

    @Override
    public IPage<RecruitBean> pageList(QueryParam param) {
        IPage<RecruitBean> page = new Page<>();
        page.setCurrent(param.getCurrent());
        page.setSize(param.getSize());
        QueryWrapper<RecruitBean> wrapper = new QueryWrapper<>();
        wrapper.eq("recruit_status", RecruitStatusEnum.VACANT.value);
        return page(page, wrapper);
    }
}
