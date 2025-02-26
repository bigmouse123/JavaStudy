package com.jiankun.spring.service.impl;

import com.jiankun.spring.dao.IStudentDao;
import com.jiankun.spring.service.IStudentService;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 17:11
 */
public class StudentServiceImpl implements IStudentService {
    private IStudentDao studentDao;

    @Override
    public void selectAll() {
        System.out.println("StudentServiceImpl.selectAll");
        studentDao.selectAll();
    }

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
