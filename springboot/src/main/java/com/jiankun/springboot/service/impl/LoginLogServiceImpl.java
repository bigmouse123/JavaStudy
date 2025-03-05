package com.jiankun.springboot.service.impl;

import com.jiankun.springboot.mapper.LoginLogMapper;
import com.jiankun.springboot.pojo.LoginLog;
import com.jiankun.springboot.service.ILoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/5 10:45
 */
@Service
public class LoginLogServiceImpl implements ILoginLogService {
    @Autowired
    private LoginLogMapper loginMapper;

    @Override
    public void add(LoginLog loginLog) {
        System.out.println(loginLog);
        loginMapper.add(loginLog);
    }
}
