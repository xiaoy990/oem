package com.xiaoy.oem.service.userService;

import com.xiaoy.oem.entity.user.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUsers();

    User queryByName(String username);

    User queryById(String id);

    void addUser(User user);

    void delUser(User user);
}
