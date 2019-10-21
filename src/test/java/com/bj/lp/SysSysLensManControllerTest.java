package com.bj.lp;

import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.controller.SysLensManController;
import com.bj.lp.sys.dao.SysLensManDao;
import com.bj.lp.sys.entity.SysLensMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysSysLensManControllerTest {
    @Autowired
    private  SysLensManController sysLensManController;
    @Autowired
   private SysLensMan sysLensMan;
    @Autowired
    private SysLensManDao sysLensManDao;

@Test
    public  void testsSavaLensMan() {

        sysLensMan.setMphone("18569488869");
        sysLensMan.setMemaile("123131");
        sysLensMan.setMjob("总监级摄影师");
        sysLensMan.setMname("李sir");
        sysLensMan.setMpin("很牛逼的摄影师啊很牛逼的摄影师啊很牛逼的摄影师啊");


    JsonResult jsonResult = sysLensManController.doSaveLensMan(sysLensMan);
    System.out.println(2);


    }


}
