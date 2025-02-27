package com.jiankun.ssm.service;

import com.jiankun.ssm.pojo.Student;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 15:13
 */
public interface IStudentService {
    public List<Student> selectAll();
    public void deleteById(Integer id);
}
