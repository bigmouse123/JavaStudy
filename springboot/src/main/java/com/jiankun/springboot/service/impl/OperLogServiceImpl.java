package com.jiankun.springboot.service.impl;

import com.jiankun.springboot.mapper.OperLogMapper;
import com.jiankun.springboot.pojo.OperLog;
import com.jiankun.springboot.service.IOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/4 20:36
 */
@Service
public class OperLogServiceImpl implements IOperLogService {
    @Autowired
    private OperLogMapper operLogMapper;

    @Override
    public void add(OperLog operLog) {
        System.out.println(operLog);
        operLogMapper.add(operLog);
    }
}
