package com.situ.web.dao;

import com.situ.web.pojo.Course;
import com.situ.web.pojo.query.CourseQuery;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 11:26
 */
public interface ICourseDao {
    List<Course> selectByPage(CourseQuery courseQuery);
    Integer selectTotalCount(CourseQuery courseQuery);

    void deleteById(int id);

    void add(Course course);

    Course selectById(int id);

    void update(Course course);
}
