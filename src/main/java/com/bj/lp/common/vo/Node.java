package com.bj.lp.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Component
public class Node implements Serializable {
    //封住验证码
    private String resultCode;
    //封装手机号
    private String phoneNum;

    public Node(String resultCode) {
        this.resultCode = resultCode;
    }
}
