package com.situ.web.service;

import com.situ.web.pojo.Teacher;
import com.situ.web.utils.PageInfo;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 19:27
 */
public interface ITeacherService {
    List<Teacher> selectAll();
    PageInfo<Teacher> selectByPage(int pageNo,int PageSize);
    void deleteById(int id);
    void add(Teacher teacher);
    Teacher selectById(int id);
    void update(Teacher teacher);
}
