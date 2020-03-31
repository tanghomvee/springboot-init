package com.homvee.springbootinit.service.impl;

import lombok.Data;

import java.io.Serializable;

@Data
public  class Test implements Serializable {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public Test() {
    }
}
