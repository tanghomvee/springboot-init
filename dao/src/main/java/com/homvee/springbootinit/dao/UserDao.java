package com.homvee.springbootinit.dao;

import com.homvee.springbootinit.dao.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Long> , UserDaoExt{

}
