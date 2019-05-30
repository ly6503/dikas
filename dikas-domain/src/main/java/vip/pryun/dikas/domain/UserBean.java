package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@TableName("user")
public class UserBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 头像地址,有默认值
     */
    private String iconUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "UserBean{" +
        "name=" + name +
        ", password=" + password +
        ", iconUrl=" + iconUrl +
        "}";
    }
}
