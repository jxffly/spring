package com.fly.user.model;




import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * Created by jinxiaofei on 16/10/17.
 */
public class Teacher implements Serializable{
    @NotNull
    private Integer bindId;
    @NotBlank
    @Length(min = 10,max = 20,message = "呵呵,名称长度10到20位!")
    private String name;
    @Range(min = 1,max=199,message = "年龄必须是1到199岁")
    private int age;
    private int role;
    private int bid;
    private Date createTime;
    private Date updateTime;

    public Integer getBindId() {
        return bindId;
    }

    public void setBindId(Integer bindId) {
        this.bindId = bindId;
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

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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
                "bind_id=" + bindId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                ", bid=" + bid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

