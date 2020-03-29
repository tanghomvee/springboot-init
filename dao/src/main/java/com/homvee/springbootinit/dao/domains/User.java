package com.homvee.springbootinit.dao.domains;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@lombok.EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_user")
@Data
public class User extends  BaseDomain {
    private String userName;
    private String userPwd;
}
