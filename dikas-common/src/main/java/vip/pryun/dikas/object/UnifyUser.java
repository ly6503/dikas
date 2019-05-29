package vip.pryun.dikas.object;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

public class UnifyUser implements Serializable {
    private static final long serialVersionUID = -4715360944617885545L;

    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String realname;
    private String avatar;
    private Set<String> roleCodes;
    private String iconImag;

    private Long userType;

    public UnifyUser() {
    }

    public UnifyUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UnifyUser(Long id, String username) {
        this.username = username;
        this.id = id;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<String> getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(Set<String> roleCodes) {
        this.roleCodes = roleCodes;
    }

    public String getIconImag() {
        return iconImag;
    }

    public void setIconImag(String iconImag) {
        this.iconImag = iconImag;
    }
}
