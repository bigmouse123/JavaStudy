package com.jiankun.ssm.service.impl;

import com.jiankun.ssm.mapper.StudentMapper;
import com.jiankun.ssm.pojo.Student;
import com.jiankun.ssm.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 15:16
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        List<Student> list = studentMapper.selectAll();
        return list;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
