package com.homvee.springbootinit.service.impl;

import com.homvee.springbootinit.dao.UserDao;
import com.homvee.springbootinit.dao.domains.User;
import com.homvee.springbootinit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @Transactional
    public Long save(Object user){
        User save;
        save = userDao.save((User) user);
        return save.getId();
    }
}
