package com.homvee.springbootinit.dao.domains;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer yn;
    private Date createTime;
    private Long  creatorId;
    private String creator;

    private Date editTime;
    private Long  editorId;
    private String  editor;
}
