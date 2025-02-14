package com.situ.web.dao;

import com.situ.web.pojo.Course;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 11:26
 */
public interface ICourseDao {
    List<Course> selectByPage(Integer offset, Integer limit);
    Integer selectTotalCount();

    void deleteById(int id);

    void add(Course course);
}
