package com.bj.lp.sys.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityTable implements Serializable {
    private static final long serialVersionUID = -4387209603580439796L;
    private Integer id;
    private String city;
    private Integer cityid;
}
