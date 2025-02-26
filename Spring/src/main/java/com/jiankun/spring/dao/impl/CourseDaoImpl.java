package com.jiankun.spring.dao.impl;

import com.jiankun.spring.dao.ICourseDao;
import org.springframework.stereotype.Controller;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 19:13
 */
@Controller("courseDao")
public class CourseDaoImpl implements ICourseDao {
    @Override
    public void selectAll() {
        System.out.println("CourseDaoImpl.selectAll");
    }
}
