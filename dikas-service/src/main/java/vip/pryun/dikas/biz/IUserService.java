package vip.pryun.dikas.biz;


import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.UserBean;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-27
 */
public interface IUserService extends IService<UserBean> {

    void saveUser();

    UserBean getUser();
}
