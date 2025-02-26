package com.jiankun.spring.service.impl;

import com.jiankun.spring.dao.IBanjiDao;
import com.jiankun.spring.service.IBanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 19:53
 */
@Service
public class BanjiServiceImpl2 implements IBanjiService {
    @Autowired
    private IBanjiDao banjiDao;
    @Override
    public void selectAll() {
        System.out.println("BanjiServiceImpl2.selectAll");
        banjiDao.selectAll();
    }
}
