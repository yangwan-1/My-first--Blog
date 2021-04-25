package com.athut.service;

import com.athut.pojo.User;

/**
 * @author yangwan
 * @create 2021-04-11 20:11
 */
public interface UserService {
User checkUser(String userName,String password);
User checkUserByNickname(String nickname,String password);
}
