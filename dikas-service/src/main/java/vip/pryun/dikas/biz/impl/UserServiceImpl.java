package vip.pryun.dikas.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.UserBean;
import vip.pryun.dikas.biz.IUserService;
import vip.pryun.dikas.dao.UserDao;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserBean> implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void saveUser() {
        UserBean user = new UserBean();
        user.setName("hx");
        user.setAge(20);
        save(user);
        redisTemplate.opsForValue().set("user",user );
    }

    @Override
    public UserBean getUser() {
        return (UserBean) redisTemplate.opsForValue().get("user");
    }
}
