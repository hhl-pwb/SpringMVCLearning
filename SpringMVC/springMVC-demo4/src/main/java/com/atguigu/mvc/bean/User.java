package com.atguigu.mvc.bean;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;

    public User(Integer id, String username, String password, Integer age, String sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }

}
