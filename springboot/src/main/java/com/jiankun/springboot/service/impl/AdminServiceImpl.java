package com.jiankun.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiankun.springboot.mapper.AdminMapper;
import com.jiankun.springboot.pojo.Admin;
import com.jiankun.springboot.pojo.query.AdminQuery;
import com.jiankun.springboot.service.IAdminService;
import com.jiankun.springboot.util.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public PageResult<Admin> selectByPage(AdminQuery adminQuery) {
//        long start = System.currentTimeMillis();
        //开始分页插件
        PageHelper.startPage(adminQuery.getPage(), adminQuery.getLimit());
        List<Admin> list = adminMapper.selectByPage(adminQuery);
        //int totalCount = adminMapper.selectTotalCount(adminQuery);
        PageInfo pageInfo = new PageInfo(list);
        int totalCount = (int) pageInfo.getTotal();
//                try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        long end = System.currentTimeMillis();
//        long time = end - start;
//        if (time >= 3000) {
//            logger.error("==========执行结束，耗时{}毫秒==========", time);
//        } else if (time >= 2000) {
//            logger.warn("==========执行结束，耗时{}毫秒==========", time);
//        } else {
//            logger.info("==========执行结束，耗时{}毫秒==========", time);
//        }
        return new PageResult<>(0, "", totalCount, list);
    }

    @Override
    public void add(Admin admin) {
        adminMapper.add(admin);
    }

    @Override
    public Admin login(String name, String password) {
        return adminMapper.login(name, password);
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        adminMapper.updateStatus(id, status);
    }
}
