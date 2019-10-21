package com.bj.lp.sys.service.impl;


import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.common.vo.Node;
import com.bj.lp.sys.service.GetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCodeServiceImpl implements GetCodeService {
    @Autowired
    private Node node;

    /**获取发送手机验证码--PhoneNumberServiceImpl--中生成的验证码 在这集进行回调取值*/
    @Override
    public String getCode(String code,String registerTel) {
        //获取之前存储的手机验证码  接收的验证码
        String resultCode = node.getResultCode();
        System.out.println("------------------------");
        System.out.println("用户接收的的验证码: "+resultCode);
        System.out.println("------------------------");
        if (!code.equals(resultCode)) {
            throw new ServiceException("输入的验证码不一致");
        }
        //对用户进行忘记密码时  手机号的封装  以便于后边通过 手机验证进行 修改密码的唯一索引
        node.setPhoneNum(registerTel);
        return null;
    }
}
