package com.bj.lp.sys.dao;


import com.bj.lp.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper

public interface UserDao {


/**--------------------------------------------------用户登录代码------------------------------------------------------------------------*/
    /**用户登录的Dao*/
    Integer findUsername(@Param("username") String username);

    /**
     * 用户登陆之前查询该用户盐值
     * @param username 用户名登陆时的用户名
     * @return
     */
    String findSalt(@Param("username") String username);

    /**
     * 用户登录之前查询该用户的密码
     * @param username
     * @return
     */
    String findPassword(@Param("username") String username);
/**--------------------------------------------------------------------------------------------------------------------------------*/







/**----------------------------------------------------用户注册之前查询是否存在相同手机号或用户名--------------------------------------*/
    /**用户注册前进行查询用户名是否重复时的Dao*/
    User doRegisterFind(@Param("RegisterUsername") String RegisterUsername,
                        @Param("RegisterTel") String RegisterTel);
/**-----------------------------------------------------------------------------------------------------------------------------*/







/**----------------------------------------用户注册时的插入用户名,密码,手机号,各自的盐值----------------------------------------------------*/
    /**用户注册使用的Dao*/
    Integer doRegister(@Param("RegisterUsername") String RegisterUsername,
                       @Param("RegisterPassword") String RegisterPassword,
                       @Param("RegisterTel") String RegisterTel,
                       @Param("salt") String salt);
/**------------------------------------------------------------------------------------------------------------------------------*/






/**-------------------------------------用户进行忘记密码操作之前的对手机号进行查询工作----------------------------------------------------*/

    Integer findNumber(@Param("RegisterTel") String RegisterTel);

    /**
     * 通过用户传进来的手机号查询数据库中与手机号对应的用户的数据
     */
    Integer updatePassword(@Param("newCode") String newCode,
                           @Param("phoneNum") String phoneNum,
                           @Param("salt") String salt);
}
/**-------------------------------------------------------------------------------------------------------------------------------*/