package com.bj.lp.sys.service.impl;

import com.bj.lp.common.vo.Node;
import com.bj.lp.sys.dao.UserDao;
import com.bj.lp.sys.service.updatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UpdatePasswordServiceImpl implements updatePasswordService {

    @Autowired
    private Node node;
    @Autowired
    private UserDao userDao;


    /**
     * -----------------------------------------------------修改用户的密码 ------------------------------------------------------
     * @param newPassword 用户传 从前端 传进来的新密码
     * @param phoneNum   用户在进行忘记密码 时 手机验证通过后将手机号在之前封装好的值取出,并作为唯一定位条件
     * @return
     */
    @Override
    public Integer updatePassword(String newPassword, String phoneNum) {
        /**将后台生成的加密密码传入到数据库中*/
        String salt = UUID.randomUUID().toString();//新生成盐值
        newPassword = DigestUtils.md5DigestAsHex((newPassword + salt).getBytes());  //新生成盐值加新密码组合的MD5 密码
        userDao.updatePassword(newPassword, phoneNum,salt); //传参 -- 调用修改密码的方法
        return null;
    }
}
