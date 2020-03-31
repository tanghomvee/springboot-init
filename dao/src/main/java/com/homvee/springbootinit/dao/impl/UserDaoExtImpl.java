package com.homvee.springbootinit.dao.impl;

import com.google.common.collect.Maps;
import com.homvee.springbootinit.dao.UserDaoExt;
import com.homvee.springbootinit.dao.domains.User;

import java.util.HashMap;

public class UserDaoExtImpl extends BaseDao<User , Long> implements UserDaoExt {
    @Override
    public Object findXXXX() throws Exception {
        return super.doSQL("select * from t_user" , Maps.newHashMap(), HashMap.class);
    }
}
