package com.fly.user.model;


import java.io.Serializable;

import lombok.Data;


/**
 * Created by jinxiaofei on 16/10/17.
 */
@Data
public class Student implements Serializable {

    private Long id;

    private String name;

    private Long tId;

    private Integer age;

    private Long cId;

}

