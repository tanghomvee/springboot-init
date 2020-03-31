package com.homvee.springbootinit.service.impl;

import com.homvee.springbootinit.dao.UserDao;
import com.homvee.springbootinit.dao.domains.User;
import com.homvee.springbootinit.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.HashMap;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    @Transactional
    public Long save(Object user){
        User save;
        save = userDao.save((User) user);
        try {
            userDao.findXXXX();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return save.getId();
    }

    @Override
    public Object list(){
        String sql = "select user_name AS name from t_user";
        Query query = this.createLocalQuery(Test.class,sql);
        return query.getResultList();
    }

    protected Query createLocalQuery(Class<?> domainClazz , String pageSQL){
        Query query = null;

        if(domainClazz != null){
            if(domainClazz.getAnnotation(Entity.class) != null){
                query = entityManager.createNativeQuery( pageSQL , domainClazz);
            }else{
                query = entityManager.createNativeQuery( pageSQL);
                if(HashMap.class.equals(domainClazz)){
                    //考虑到对性能的影响,建议别将结果集转为Map
                    /**
                     * vlad(Hibernate Team member)
                     * setResultTransformer
                     * For the moment, there is no replacement.
                     * In 6.0, the ResultTransformer will be replaced by a @FunctionalInterface, but the underlying mechanism of transforming the Object[] property values will probably be the same.
                     * Therefore, you can use it as-is and, only if you upgrade to 6.0, you will have to think about replacing it with the new variant.
                     */
                    query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                }else{
                    query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(domainClazz));
                }
            }
        }else {
            query = entityManager.createNativeQuery( pageSQL);
        }
        return  query;
    }
}

