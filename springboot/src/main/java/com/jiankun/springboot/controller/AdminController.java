package com.jiankun.springboot.controller;

import com.jiankun.springboot.pojo.Admin;
import com.jiankun.springboot.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 10:42
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Admin> selectAll() {
//        System.out.println("StudentController.selectAll");
//        List<Admin> list = new ArrayList<>();
//        Admin admin1 = new Admin();
//        admin1.setId(1);
//        admin1.setName("zhangsan");
//        Admin admin2 = new Admin();
//        admin2.setId(2);
//        admin2.setName("list");
//        Admin admin3 = new Admin();
//        admin3.setId(3);
//        admin3.setName("wangwu");
//        list.add(admin1);
//        list.add(admin2);
//        list.add(admin3);
//        return list;
        return adminService.selectAll();
    }

    @RequestMapping("/toList")
    public String toList() {
        return "admin_list";
    }
}
