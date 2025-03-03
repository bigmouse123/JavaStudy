package com.jiankun.springboot.service;

import com.jiankun.springboot.pojo.Admin;
import com.jiankun.springboot.pojo.query.AdminQuery;
import com.jiankun.springboot.util.PageResult;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 11:03
 */
public interface IAdminService {
    public List<Admin> selectAll();

    PageResult<Admin> selectByPage(AdminQuery adminQuery);

    void add(Admin admin);

    Admin login(String name, String password);

    void updateStatus(Integer id, Integer status);
}
