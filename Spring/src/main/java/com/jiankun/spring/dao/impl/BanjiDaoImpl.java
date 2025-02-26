package com.jiankun.spring.dao.impl;

import com.jiankun.spring.dao.IBanjiDao;
import org.springframework.stereotype.Repository;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 19:51
 */
@Repository
public class BanjiDaoImpl implements IBanjiDao {
    @Override
    public void selectAll() {
        System.out.println("BanjiDaoImpl.selectAll");
    }
}
