package com.jiankun.springboot.service.impl;

import com.jiankun.springboot.mapper.AdminMapper;
import com.jiankun.springboot.pojo.Admin;
import com.jiankun.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 11:04
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }
}
