package vip.pryun.dikas.service;


import vip.pryun.dikas.object.UnifyUser;

public interface UnifyUserService {
    /**
     * 根据用户名获取用户基本信息
     *
     * @param username 用户名
     * @return 用户基本信息对象或 null
     */
    UnifyUser loadUserByPhone(String username);
}
