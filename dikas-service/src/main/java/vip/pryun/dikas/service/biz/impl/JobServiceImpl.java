package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.domain.JobBean;
import vip.pryun.dikas.persistence.dao.JobDao;
import vip.pryun.dikas.service.biz.IJobService;
import vip.pryun.dikas.service.enums.JobStatusEnum;

/**
 * <p>
 * 职务表 服务实现类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobDao, JobBean> implements IJobService {

    @Override
    public IPage<JobBean> pageList(QueryParam param) {
        IPage<JobBean> page = new Page<>();
        page.setCurrent(param.getCurrent());
        page.setSize(param.getSize());
        QueryWrapper<JobBean> wrapper = new QueryWrapper<>();
        wrapper.eq("job_status", JobStatusEnum.VACANT.value);
        return page(page, wrapper);
    }
}
