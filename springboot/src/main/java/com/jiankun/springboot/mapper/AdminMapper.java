package com.jiankun.springboot.mapper;

import com.jiankun.springboot.pojo.Admin;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 11:07
 */
public interface AdminMapper {
    public List<Admin> selectAll();
}
