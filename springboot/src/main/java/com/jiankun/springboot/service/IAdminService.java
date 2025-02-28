package com.jiankun.springboot.service;

import com.jiankun.springboot.pojo.Admin;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 11:03
 */
public interface IAdminService {
    public List<Admin> selectAll();
}
