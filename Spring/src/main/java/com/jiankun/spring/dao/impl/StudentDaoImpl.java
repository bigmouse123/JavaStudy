package com.jiankun.spring.dao.impl;

import com.jiankun.spring.dao.IStudentDao;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 17:17
 */
public class StudentDaoImpl implements IStudentDao {
    @Override
    public void selectAll() {
        System.out.println("StudentDaoImpl.selectAll");
    }
}
