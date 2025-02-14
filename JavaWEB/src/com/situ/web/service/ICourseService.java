package com.situ.web.service;

import com.situ.web.pojo.Course;
import com.situ.web.utils.PageResult;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 11:18
 */
public interface ICourseService {
    PageResult<Course> selectByPage(Integer page, Integer limit);

    void deleteById(int id);

    void add(Course course);
}
