package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.CompanyAbstractBean;
import vip.pryun.dikas.persistence.dao.CompanyAbstractDao;
import vip.pryun.dikas.service.biz.ICompanyAbstractService;

/**
 * <p>
 * 公司简介 服务实现类
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@Service
public class CompanyAbstractServiceImpl extends ServiceImpl<CompanyAbstractDao, CompanyAbstractBean> implements ICompanyAbstractService {

}
