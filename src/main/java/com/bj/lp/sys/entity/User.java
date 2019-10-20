package com.bj.lp.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class User implements Serializable {
    //用户注册唯一的ID
    private Integer Id;
    //用户注册的用户名
    private String customersUserName;
    //用户注册的密码
    private String customersPassword;
    //用户的电话号码
    private String customersTel;
    //用户的注册日期
    private Date customersCreateTime;

    private String salt;//盐值

}
