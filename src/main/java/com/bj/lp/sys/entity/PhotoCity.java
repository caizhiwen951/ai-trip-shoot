package com.bj.lp.sys.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhotoCity implements Serializable {
    private static final long serialVersionUID = -6984915397865747513L;
    private Integer id;
    private Integer cityId;
    private String imgUrl;
}
