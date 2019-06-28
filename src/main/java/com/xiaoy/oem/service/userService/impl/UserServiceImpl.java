package com.xiaoy.oem.service.userService.impl;

import com.xiaoy.oem.entity.user.User;
import com.xiaoy.oem.mapper.userMapper.UserMapper;
import com.xiaoy.oem.service.userService.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUsers() {
        return userMapper.queryAllUsers();
    }

    @Override
    public User queryByName(String username) {
        return userMapper.queryByName(username);
    }

    @Override
    public User queryById(String id) {
        return userMapper.queryById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(User user) {
        userMapper.delUser(user);
    }
}
