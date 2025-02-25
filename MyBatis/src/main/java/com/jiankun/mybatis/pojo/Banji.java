package com.jiankun.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/25 15:16
 */
@Data
public class Banji {
    private int id;
    private String name;
    private List<Student> list;
}
