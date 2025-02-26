package com.jiankun.spring.controller;

import com.jiankun.spring.service.ICourseService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 19:10
 */
@Controller("courseController")
public class CourseController {
    @Resource(name = "courseService")
    private ICourseService courseService;

    public void selectAll() {
        System.out.println("CourseController.selectAll");
        courseService.selectAll();
    }
}
