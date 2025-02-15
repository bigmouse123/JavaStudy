package com.situ.web.service;

import com.situ.web.pojo.Course;
import com.situ.web.pojo.query.CourseQuery;
import com.situ.web.utils.PageResult;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 11:18
 */
public interface ICourseService {
    PageResult<Course> selectByPage(CourseQuery courseQuery);

    void deleteById(int id);

    void add(Course course);

    Course selectById(int id);

    void update(Course course);

    void deleteAll(String[] ids);
}
