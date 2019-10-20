package com.bj.lp.sys.service.impl;

import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.common.vo.Node;
import com.bj.lp.sys.dao.UserDao;
import com.bj.lp.sys.service.PhoneNumberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Data
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    Node node;
    @Autowired
    UserDao userDao;

    /**---------------------------------------注册前的手机号查重---------------------------------------------------------*/
    @Override
    public Integer findNumber(String RegisterTel) {
        Integer findRegisterTel = userDao.findNumber(RegisterTel);
        if (findRegisterTel == 0) {
            throw new ServiceException("该手机号还未注册,请先注册");
        }
        return null;
    }




    /**-------------------------------------------------发送手机验证码的核心代码-----------------------------------------------*/
    @Override
    public String sendMessage(String RegisterTel) {
        /** 注册时的手机验证码生成方法*/
        /**随机验证码生成*/
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result = result + random.nextInt(10);
        }
        System.out.println(result);
        ObjectMapper mapper = new ObjectMapper();
        String resultCode = null;
        try {
            resultCode = mapper.writeValueAsString(result);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        /*DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FnmZ4TMCRuGP5NScWyD", "lDGkXnVEZTngovC5NSBfPhYweHFWdH");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", RegisterTel);
        request.putQueryParameter("SignName", "爱旅拍");
        request.putQueryParameter("TemplateCode", "SMS_175485073");
        request.putQueryParameter("TemplateParam", "{code:" + resultCode + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }*/

        //输出生成的验证码
        System.out.println("生成的验证码: "+result);
        //将生成的验证码封装起来,封装到node里面
        node.setResultCode(result);

        return result;
    }


}
