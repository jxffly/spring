package com.fly.user.model;

import java.util.Date;

/**
 * Created by jinxiaofei on 16/10/17.
 */
public class Person {
    private int bind_id;
    private String name;
    private int age;
    private int role;
    private Date createTime;
    private Date updateTime;

    public int getBind_id() {
        return bind_id;
    }

    public void setBind_id(int bind_id) {
        this.bind_id = bind_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "bind_id=" + bind_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

