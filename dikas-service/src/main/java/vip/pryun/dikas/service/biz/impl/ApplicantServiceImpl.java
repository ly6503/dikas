package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.common.mybatis.annotation.transaction.ITransactional;
import vip.pryun.dikas.common.object.UnifyUser;
import vip.pryun.dikas.common.util.bean.BeanUtils;
import vip.pryun.dikas.domain.ApplicantBean;
import vip.pryun.dikas.domain.RecruitBean;
import vip.pryun.dikas.persistence.dao.ApplicantDao;
import vip.pryun.dikas.service.biz.IApplicantService;
import vip.pryun.dikas.service.biz.IRecruitService;
import vip.pryun.dikas.service.enums.ApprovalStatusEnum;
import vip.pryun.dikas.service.enums.RecruitStatusEnum;

import java.util.List;
import java.util.Objects;

import static com.google.common.collect.Lists.newArrayList;

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
    private IRecruitService recruitService;

    @ITransactional
    @Override
    public Boolean saveApplicant(ApplicantBean applicantBean) {
        QueryWrapper<RecruitBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("recruit_name", applicantBean.getJobName());
        RecruitBean job = recruitService.getOne(queryWrapper);
        
        UpdateWrapper<RecruitBean> uwp = new UpdateWrapper<>();
        BeanUtils.addUpdateInfo(job, new UnifyUser(0L, "robot"));
        if (job.getNeedNumber() == 0) {
            uwp.set("recruit_status", RecruitStatusEnum.NONVACANT.value);
            return recruitService.update(job,uwp);
        } else {
            uwp.set("need_number", job.getNeedNumber() - 1);
        }
        boolean update = recruitService.update(job,uwp);
        if (update) {
            BeanUtils.addEntryInfo(applicantBean, new UnifyUser(0L, "robot"));
            boolean save = save(applicantBean);
            if (!save) {
                uwp = new UpdateWrapper<>();
                uwp.set("need_number", job.getNeedNumber() - 1);
                update = recruitService.update(uwp);
            }
            return save && update;
        }
        return false;
    }

    @Override
    @ITransactional
    public Boolean updateOrDelete(List<ApplicantBean> applicantBeans) {
        List<Long> delList = newArrayList();
        List<ApplicantBean> updateList = newArrayList();
        applicantBeans.stream().filter(Objects::nonNull)
                .forEach(applicantBean -> {
                    if (ApprovalStatusEnum.REFUSE.value.equals(applicantBean.getApprovalStatus())) {
                        //删除逻辑
                        delList.add(applicantBean.getId());
                    } else {
                        //更新逻辑
                        BeanUtils.addUpdateInfo(applicantBean, new UnifyUser(0L, "robot"));
                        updateList.add(applicantBean);
                    }
                });
        boolean remove = true;
        boolean batch = true;
        if (delList.size() > 0) {
            remove = removeByIds(delList);
        }

        if (updateList.size() > 0) {
            batch = updateBatchById(updateList);
        }
        return remove && batch;
    }
}
