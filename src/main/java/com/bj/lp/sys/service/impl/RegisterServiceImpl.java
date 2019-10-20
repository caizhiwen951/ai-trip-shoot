package com.bj.lp.sys.service.impl;

import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.common.vo.Node;
import com.bj.lp.sys.dao.UserDao;
import com.bj.lp.sys.entity.User;
import com.bj.lp.sys.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**-------------------------------------------------------用户进行注册的业务层-----------------------------------------------------*/
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Node node;

    @Override
    public User doRegister(String RegisterUsername, String RegisterPassword, String RegisterTel, String okok) {
        String UM = "[^0-15][\\w_]{5,9}";
        if (RegisterUsername.matches(UM)) {
        } else {
            throw new ServiceException("您输入的用户名格式不正确");
        }
        String PW = "[\\w_]{6,20}";
        if (RegisterPassword.matches(PW)) {
        } else {
            throw new ServiceException("密码格式不正确");
        }
        User findRegisterUsername = userDao.doRegisterFind(RegisterUsername,RegisterTel);
        if (findRegisterUsername != null) {
            throw new ServiceException("用户名或手机号已被注册,如忘记密码,可去找回密码");
        }
        String getCode = node.getResultCode();
        System.out.println(getCode);
        if (!okok.equals(getCode)) {
            throw new ServiceException("验证码输入不正确");
        }


        /**
         * 1.  新生成一个盐值.
         * 2.  在对用户传进来的密码和新生成的盐值进行MD5加密.
         * 3.  调用dao层uesrDao的方法, 对注册事件进行传参 跳转下一步.
         */
        String salt = UUID.randomUUID().toString();//盐值生成
        RegisterPassword = DigestUtils.md5DigestAsHex((RegisterPassword + salt).getBytes());//MD5生成
        userDao.doRegister(RegisterUsername, RegisterPassword, RegisterTel,salt); //传参 调用方法
        return null;
    }
}
