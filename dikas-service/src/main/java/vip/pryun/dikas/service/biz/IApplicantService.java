package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.domain.ApplicantBean;

/**
 * <p>
 * 求职者表 服务类
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
public interface IApplicantService extends IService<ApplicantBean> {
    Boolean saveApplicant(ApplicantBean applicantBean);
}
