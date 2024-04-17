package com.zhang.ssmschoolshop.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userid;

    private String username;

    private String password;

    private Date regtime;

    private String email;

    private String telephone;
}