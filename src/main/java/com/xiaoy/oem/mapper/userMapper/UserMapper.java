package com.xiaoy.oem.mapper.userMapper;

import com.xiaoy.oem.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryAllUsers();

    User queryByName(@Param("name") String username);

    User queryById(@Param("id")String id);

    void addUser(@Param("user")User user);

    void delUser(@Param("user")User user);
}
