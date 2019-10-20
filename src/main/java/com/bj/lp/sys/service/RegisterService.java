package com.bj.lp.sys.service;

import com.bj.lp.sys.entity.User;

public interface RegisterService {
    /**--------------------------------------注册业务端--------------------------------------------*/
    User doRegister(String RegisterUsername, String RegisterPassword, String RegisterTel, String okok);
}
