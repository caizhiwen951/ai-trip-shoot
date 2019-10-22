package com.bj.lp.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data

public class JsonResult implements Serializable {
    private static final long serialVersionUID = 874154493505251116L;
//    状态码 1表示success，0表示error
    private  int state=1;
//    状态信息
    private String message="ok";
//    正确数据
    private Object data;

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    public JsonResult(Throwable e){
        this.state = 0;
        this.message=e.getMessage();
    }


}
