package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.UserBean;
import vip.pryun.dikas.persistence.dao.UserDao;
import vip.pryun.dikas.service.biz.IUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserBean> implements IUserService {

}
