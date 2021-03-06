package com.fly.user.model;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;


/**
 * Created by jinxiaofei on 16/10/17.
 */
@Data
public class Teacher implements Serializable {

    private Long id;

    private String name;

    private Integer sex;

    private Long cId;

    private Date updateTime;

    private Date createTime;
}

