package com.athut.mapper;

import com.athut.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yangwan
 * @create 2021-04-11 20:36
 */
@Mapper
public interface UserMapper  {
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    User findUserByNicknameAndPassword(@Param("nickname") String username, @Param("password") String password);
}
