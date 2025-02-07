package com.situ.web.dao;

import com.situ.web.pojo.Teacher;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 19:27
 */
public interface ITeacherDao {
    List<Teacher> selectAll();

    Teacher selectById(int id);

    void deleteById(int id);

    void update(Teacher teacher);

    List<Teacher> selectByPage(int pageNo, int pageSize);

    void add(Teacher teacher);

    int selectTotalCount();
}
