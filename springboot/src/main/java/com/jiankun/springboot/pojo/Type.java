package com.jiankun.springboot.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 10:43
 */
@Data
public class Type {
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
}