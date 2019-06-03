package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.ApplicantBean;
import vip.pryun.dikas.domain.RecruitBean;
import vip.pryun.dikas.persistence.dao.ApplicantDao;
import vip.pryun.dikas.service.biz.IApplicantService;
import vip.pryun.dikas.service.biz.IRecruitService;
import vip.pryun.dikas.service.enums.JobStatusEnum;

/**
 * <p>
 * 求职者表 服务实现类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@Service
public class ApplicantServiceImpl extends ServiceImpl<ApplicantDao, ApplicantBean> implements IApplicantService {

    @Autowired
    private IRecruitService jobService;
    @Override
    public Boolean saveApplicant(ApplicantBean applicantBean) {
        QueryWrapper<RecruitBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("recruit_name", applicantBean.getJobName());
        RecruitBean job = jobService.getOne(queryWrapper);
        UpdateWrapper<RecruitBean> uwp = new UpdateWrapper<>();
        if (job.getNeedNumber() == 0) {
            uwp.set("recruit_status", JobStatusEnum.NONVACANT.value);
            return jobService.update(uwp);
        } else {
            uwp.set("need_number", job.getNeedNumber() - 1);
        }
        boolean update = jobService.update(uwp);
        boolean save = save(applicantBean);
        if (!save && update) {
            uwp = new UpdateWrapper<>();
            uwp.set("need_number", job.getNeedNumber() - 1);
            update = jobService.update(uwp);
        }
        return save && update;
    }
}
