package com.situ.web.service.impl;

import com.situ.web.dao.IStudentDao;
import com.situ.web.dao.impl.StudentDaoImpl;
import com.situ.web.pojo.Student;
import com.situ.web.service.IStudentService;
import com.situ.web.utils.PageInfo;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 14:25
 */
public class StudentServiceImpl implements IStudentService {

    private IStudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public Student selectById(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public PageInfo<Student> selectByPage(int pageNo, int pageSize) {
        int offset = (pageNo - 1) * pageSize;
        List<Student> list = studentDao.selectByPage(offset, pageSize);
        int totalCount = studentDao.selectTotalCount();
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
        PageInfo<Student> pageInfo = new PageInfo<>(list, totalPage, pageNo, pageSize);
        return pageInfo;
    }
}
