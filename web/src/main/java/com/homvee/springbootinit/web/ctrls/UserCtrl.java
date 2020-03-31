package com.homvee.springbootinit.web.ctrls;

import com.homvee.springbootinit.dao.domains.User;
import com.homvee.springbootinit.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = {"/user"})
public class UserCtrl {

    @Resource
    private UserService userService;
    @PostMapping("add")
    @ResponseBody
    public User add(User user){
        userService.save(user);
        userService.list();
        return user;
    }
}
