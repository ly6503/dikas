package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.ServiceBean;
import vip.pryun.dikas.persistence.dao.ServiceDao;
import vip.pryun.dikas.service.biz.IServiceService;

/**
 * <p>
 * 服务支持 服务实现类
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@Service
public class ServiceServiceImpl extends ServiceImpl<ServiceDao, ServiceBean> implements IServiceService {

}
