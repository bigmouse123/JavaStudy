package com.jiankun.spring.controller;

import com.jiankun.spring.service.IStudentService;
import com.jiankun.spring.service.impl.StudentServiceImpl;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 17:10
 */
public class StudentController {
    private IStudentService studentService;

    public void selectAll() {
        System.out.println("StudentController.selectAll");
        studentService.selectAll();
    }

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }
}
