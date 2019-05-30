package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.ApplicantBean;
import vip.pryun.dikas.persistence.dao.ApplicantDao;
import vip.pryun.dikas.service.biz.IApplicantService;

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

}
