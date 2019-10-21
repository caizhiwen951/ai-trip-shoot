package com.bj.lp.sys.service;


public interface PhoneNumberService {
    /**注册手机号接收验证码*/
    String sendMessage(String RegisterTel);

    /**
     * 接收手机号 查询数据库是否存在此用户
     */
    Integer findNumber(String RegisterTel);




}
