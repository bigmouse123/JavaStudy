package com.jiankun.springboot.mapper;

import com.jiankun.springboot.pojo.Admin;
import com.jiankun.springboot.pojo.query.AdminQuery;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 11:07
 */
public interface AdminMapper {
    List<Admin> selectAll();

    List<Admin> selectByPage(AdminQuery adminQuery);

    void add(Admin admin);

    Admin login(String name, String password);

    void updateStatus(Integer id, Integer status);
}
