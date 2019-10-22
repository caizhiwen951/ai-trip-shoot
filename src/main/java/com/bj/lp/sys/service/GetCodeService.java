package com.bj.lp.sys.service;

public interface GetCodeService {
/**-----------------------------------------------------接收验证码------------------------------------------------*/
    String getCode(String Code, String RegisterTel);
}
