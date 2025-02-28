package com.jiankun.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 17:22
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/search")
    public String search(Integer id, String name) {
        System.out.println("StudentController.search");
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        return "index";
    }
}
