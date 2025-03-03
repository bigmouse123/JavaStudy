package com.jiankun.springboot.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 10:43
 */
@Data
public class Admin {
    private Integer id;
    private String name;
    private String password;
    private Integer role;
    private String phone;
    private String email;
    private String image;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}