package com.situ.web.service.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.dao.impl.TeacherDaoImpl;
import com.situ.web.pojo.Teacher;
import com.situ.web.service.ITeacherService;
import com.situ.web.utils.PageInfo;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 19:41
 */
public class TeacherServiceImpl implements ITeacherService {

    ITeacherDao teacherDao = new TeacherDaoImpl();

    @Override
    public List<Teacher> selectAll() {
        return teacherDao.selectAll();
    }

    @Override
    public PageInfo<Teacher> selectByPage(int pageNo, int pageSize) {
        int offset = (pageNo - 1) * pageSize;
        List<Teacher> list = teacherDao.selectByPage(offset, pageSize);
        int totalCount = teacherDao.selectTotalCount();
        int totalPage = (int) (Math.ceil((double) totalCount / pageSize));
        PageInfo<Teacher> pageInfo = new PageInfo<>(list, totalPage, pageNo, pageSize);
        return pageInfo;
    }

    @Override
    public void deleteById(int id) {
        teacherDao.deleteById(id);
    }

    @Override
    public void add(Teacher teacher) {
        teacherDao.add(teacher);
    }

    @Override
    public Teacher selectById(int id) {
        return teacherDao.selectById(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }
}
