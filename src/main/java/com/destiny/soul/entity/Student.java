package com.destiny.soul.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhuhaifeng
 * @since 2020-11-26
 */
@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String age;
    private Date createTime;
}
