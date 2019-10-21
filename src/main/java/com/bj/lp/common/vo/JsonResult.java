package com.bj.lp.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult implements Serializable {

    //状态信息 ok表示成功
    private String message = "ok";
    //状态码 1成功  0 错误
    private int state = 1;
    //传入的数据 数据信息
    private Object data;

    public JsonResult() {
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Throwable e) {
        this.state = 0;
        this.message = e.getMessage();
    }

}
