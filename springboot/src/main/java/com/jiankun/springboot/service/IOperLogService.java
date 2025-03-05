package com.jiankun.springboot.service;

import com.jiankun.springboot.pojo.OperLog;
import org.springframework.stereotype.Service;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/4 20:35
 */
public interface IOperLogService {
    public void add(OperLog operLog);
}
