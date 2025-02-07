package com.situ.web.service;

import com.situ.web.pojo.Student;
import com.situ.web.utils.PageInfo;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 14:24
 */
public interface IStudentService {
    List<Student> selectAll();
    void deleteById(int id);
    void add(Student student);
    Student selectById(int id);
    void update(Student student);
    PageInfo<Student> selectByPage(int pageNo, int pageSize);
}
