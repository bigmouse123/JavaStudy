package com.jiankun.springboot.controller;

import com.jiankun.springboot.pojo.Admin;
import com.jiankun.springboot.pojo.query.AdminQuery;
import com.jiankun.springboot.service.IAdminService;
import com.jiankun.springboot.util.PageResult;
import com.jiankun.springboot.util.Result;
import jakarta.servlet.http.HttpSession;
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

    @RequestMapping("/selectByPage")
    @ResponseBody
    public PageResult<Admin> selectByPage(AdminQuery adminQuery) {
        PageResult<Admin> pageResult = adminService.selectByPage(adminQuery);
        return pageResult;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(Admin admin) {
        adminService.add(admin);
        return Result.ok("添加成功");
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(String name, String password, HttpSession session) {
        Admin admin = adminService.login(name, password);
        if (admin == null) {
            return Result.error("用户名或密码错误");
        }
        if (admin.getStatus() == 0) {
            return Result.error("该用户被封禁");
        }
        session.setAttribute("admin", admin);
        return Result.ok("登录成功");
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpSession session) {
        session.removeAttribute("admin");
        return Result.ok("注销成功");
    }

    @RequestMapping("/updateStatus")
    @ResponseBody
    public Result updateStatus(Integer id, Integer status) {
        adminService.updateStatus(id, status);
        return Result.ok("修改状态成功");
    }

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
