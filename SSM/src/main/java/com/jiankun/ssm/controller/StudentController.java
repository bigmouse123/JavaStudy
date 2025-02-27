package com.jiankun.ssm.controller;

import com.jiankun.ssm.pojo.Student;
import com.jiankun.ssm.service.IStudentService;
import com.jiankun.ssm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 15:17
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Student> selectAll() {
        List<Student> list = studentService.selectAll();
        return list;
    }

    @RequestMapping("/selectAll2")
    public String selectAll2(Model model) {
        List<Student> list = studentService.selectAll();
        model.addAttribute("list", list);
        return "/WEB-INF/student_list.jsp";
    }

    @RequestMapping("/selectAll3")
    @ResponseBody
    public Result selectAll3() {
        List<Student> list = studentService.selectAll();
        return Result.ok(list);
    }
}
