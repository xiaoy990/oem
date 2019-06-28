package com.xiaoy.oem.controller.userController;

import com.xiaoy.oem.entity.user.User;
import com.xiaoy.oem.service.userService.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("home")
    public String home(){
        return "redirect:/homeExam";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request,User userClient){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userClient.getUsername(),userClient.getPassword());
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            return "redirect:toLogin";
        }catch (IncorrectCredentialsException e){
            return "redirect:toLogin";
        }
        HttpSession session = request.getSession();
        User user = (User)subject.getPrincipal();
        System.out.println(user);
        if (user.getPerms().equals("perm:teacher")) {
            session.setAttribute("perm", 0);
        }else {
            session.setAttribute("perm",1);
        }
        session.setAttribute("username",user.getUsername());
        return "redirect:home";
    }

    @RequestMapping("register")
    public String register(User user){
        userService.addUser(user);
        return "redirect:toLogin";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "user/register";
    }

}
