package com.xiaoy.oem.config;

import com.xiaoy.oem.entity.user.User;
import com.xiaoy.oem.service.userService.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {
    @Resource
    UserService userService;
    /**
     * 授权逻辑
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权逻辑");
        AuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        userService.queryById(String.valueOf(user.getId()));
        ((SimpleAuthorizationInfo) info).addStringPermission(String.valueOf(user.getPerms()));
        return info;
    }

    /**
     * 认证逻辑
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.queryByName(token.getUsername());
        if(user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"UserRealm");
    }
}
