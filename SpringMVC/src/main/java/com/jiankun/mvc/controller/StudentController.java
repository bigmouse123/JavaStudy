package com.jiankun.mvc.controller;

import com.jiankun.mvc.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/24 15:26
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/add1")
    public void add1(String name, Integer age, String gender) {
        System.out.println("StudentController.add1");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
    }

    @RequestMapping("/add2")
    public ModelAndView add2(Student student) {
        System.out.println("StudentController.add2");
        System.out.println(student);

        //Model:数据  View：界面
        ModelAndView mav = new ModelAndView();
        //request.setAttribute("student", student);
        mav.addObject("student", student);
        //request.getRequestDispatcher("/student_info.jsp").forward(req, resp);
        mav.setViewName("/student_info.jsp");
        return mav;
    }

    @RequestMapping(value = "/add3", method = {RequestMethod.GET, RequestMethod.POST})
    public String add3(Student student, Model model) {
        System.out.println("StudentController.add3");
        System.out.println(student);

        //request.setAttribute("student", student);
        //request.getRequestDispatcher("/student_info.jsp").forward();
        model.addAttribute("student", student);
        return "/student_info.jsp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        System.out.println("StudentController.add()");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        Student student = new Student(null, name, Integer.parseInt(age), gender);
        System.out.println(student);
        request.setAttribute("student", student);
        request.getRequestDispatcher("/student_info.jsp").forward(request, response);
    }

    @RequestMapping("/deleteAll")
    public void deleteAll(Integer ids[]) {
        System.out.println("StudentController.deleteAll");
        System.out.println(Arrays.toString(ids));
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        System.out.println("StudentController.deleteById");
        System.out.println("id: " + id);
        return "redirect:/student/selectAll";
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        System.out.println("StudentController.selectAll");
        return "/student_list.jsp";
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Student selectById(Integer id){
        Student student = new Student(1, "张三1", 23, "男");
        return student;
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Student> select(){
        Student student1 = new Student(1, "张三1", 23, "男");
        Student student2 = new Student(2, "张三2", 23, "男");
        Student student3 = new Student(3, "张三3", 23, "男");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        return list;
    }

}
