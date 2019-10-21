package com.bj.lp.sys.entity;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class SysLensMan {
    //    //摄影师ID
    private Integer mid;
    //摄影师称呼
    private String mname;
    //摄影师电话
    private  String mphone;
    //摄影师邮箱
    private  String memaile;
    //摄影师职位
    private  String mjob;
    //摄影师简介
    private  String mpin;



}
