package com.homvee.springbootinit.dao;

import com.homvee.springbootinit.dao.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

}
