package com.situ.web.dao;

import com.situ.web.pojo.Student;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/4 3:42
 */
public interface IStudentDao {
    List<Student> selectAll();
    void deleteById(int id);
    void add(Student student);
    Student selectById(int id);
    void update(Student student);
    List<Student> selectByPage(int offset, int pageSize);
    int selectTotalCount();
}
