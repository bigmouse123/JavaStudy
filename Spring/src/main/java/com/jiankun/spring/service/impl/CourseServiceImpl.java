package com.jiankun.spring.service.impl;

import com.jiankun.spring.dao.ICourseDao;
import com.jiankun.spring.service.ICourseService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 19:12
 */
@Controller("courseService")
public class CourseServiceImpl implements ICourseService {
    @Resource(name = "courseDao")
    private ICourseDao courseDao;

    @Override
    public void selectAll() {
        System.out.println("CourseServiceImpl.selectAll");
        courseDao.selectAll();
    }
}
