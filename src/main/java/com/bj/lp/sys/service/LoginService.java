package com.bj.lp.sys.service;

/**----------------------------------------登录业务端---------------------------------------------*/
public interface LoginService {
    Integer findUsername(String username, String password);
}
