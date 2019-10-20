package com.bj.lp.sys.service.impl;

import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.sys.dao.UserDao;
import com.bj.lp.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**------------------------------------------------用户登录的业务层--------------------------------------------------------------*/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer findUsername(String username, String password) {

        //用户登录 用户名的判断
        if (username == null || username == "") {
            throw new ServiceException("用户名或密码不能为空");
        }
        //用户登录  用户名的正则表达式判断
        String UM = "[^0-9][\\w_]{5,9}";
        if (username.matches(UM)) {
        } else {
            throw new ServiceException("用户名格式不正确(格式:11位字母加数字组合)");
        }
        //用户登录   密码的正则表达式判断
        String PW = "[\\w_]{6,20}";
        if (password.matches(PW)) {
        } else {
            throw new ServiceException("密码格式不正确(格式:11位字母加数字组合)");
        }
        Integer newUsername = userDao.findUsername(username);
        if (newUsername == 0) {
            throw new ServiceException("用户名或密码不正确");
        }

        /** 登陆时 用户输入的密码+查询数据库中的盐值要====数据库查询出的密码(密码加MD5的合并)*/
        String salt = userDao.findSalt(username);//原用户的盐值
        String newPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());//原盐值加传进来的密码生成的MD5密码
        String oldPassword = userDao.findPassword(username);//用户数据库中的原Md5密码
        //对两个密码进行取值判断
        if (!newPassword.equals(oldPassword)) {
            throw new ServiceException("用户名或密码不正确");
        }
        System.out.println("登陆成功");
        return null;
    }
}
