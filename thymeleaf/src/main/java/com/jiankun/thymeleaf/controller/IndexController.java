package com.jiankun.thymeleaf.controller;

import com.jiankun.thymeleaf.pojo.Student;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 14:15
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "HelloWorld");

        Student student = new Student(1, "李四", 23, new Date());
        model.addAttribute("student", student);

        Student student1 = new Student(1, "张三1", 23, new Date());
        Student student2 = new Student(2, "张三2", 23, new Date());
        Student student3 = new Student(3, "张三3", 23, new Date());
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping("/data")
    public String data(HttpServletRequest request, HttpSession session) {
        Student student1 = new Student(1, "张三1", 23, new Date());
        request.setAttribute("student1", student1);

        Student student2 = new Student(2, "张三2", 23, new Date());
        session.setAttribute("student2", student2);

        Student student3 = new Student(3, "张三3", 23, new Date());
        ServletContext application = request.getServletContext();
        application.setAttribute("student3", student3);

        return "data";
    }

    @RequestMapping(value = "/util")
    public String set(Model model) {
        Set<String> names = new HashSet<String>() ;
        List<Integer> ids = new ArrayList<Integer>() ;
        for (int i = 0 ; i < 5 ; i ++) {
            names.add("boot-" + i) ;
            ids.add(i) ;
        }
        model.addAttribute("names", names) ;
        model.addAttribute("ids", ids) ;
        model.addAttribute("mydate", new Date()) ;
        return "util" ;
    }

    @RequestMapping("/toUrl")
    public String toUrl(Model model) {
        Student student = new Student();
        student.setId(1);
        student.setName("zhang");
        model.addAttribute("student", student);

        return "url";
    }
}