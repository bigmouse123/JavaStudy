package com.situ.web.service.impl;

import com.situ.web.dao.ICourseDao;
import com.situ.web.dao.impl.CourseDaoImpl;
import com.situ.web.pojo.Course;
import com.situ.web.service.ICourseService;
import com.situ.web.utils.PageResult;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 11:19
 */
public class CourseServiceImpl implements ICourseService {
    private ICourseDao courseDao = new CourseDaoImpl();

    @Override
    public PageResult<Course> selectByPage(Integer page, Integer limit) {
        int offset = (page - 1) * limit;
        List<Course> data = courseDao.selectByPage(offset, limit);
        int totalCount = courseDao.selectTotalCount();
        PageResult<Course> pageResult = new PageResult<>(0, "", totalCount, data);
        return pageResult;
    }

    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    @Override
    public void add(Course course) {
        courseDao.add(course);
    }
}
