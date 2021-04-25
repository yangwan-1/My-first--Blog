package com.athut.service.impl;

import com.athut.mapper.UserMapper;
import com.athut.pojo.User;
import com.athut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangwan
 * @create 2021-04-11 20:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String userName, String password) {
        User user = userMapper.findUserByUsernameAndPassword(userName, password);
        return user;
    }

    @Override
    public User checkUserByNickname(String nickname, String password) {
        return userMapper.findUserByNicknameAndPassword(nickname,password);
    }
}
