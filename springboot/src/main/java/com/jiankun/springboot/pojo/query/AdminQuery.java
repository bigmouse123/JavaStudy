package com.jiankun.springboot.pojo.query;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/3 11:14
 */

import lombok.Data;

import java.util.Date;

@Data
public class AdminQuery {
    private Integer page;
    private Integer limit;
    private String name;
    private Integer role;
    private Date beginCreateTime;
    private Date endCreateTime;
}
