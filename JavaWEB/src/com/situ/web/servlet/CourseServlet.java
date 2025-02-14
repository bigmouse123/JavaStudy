package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.Course;
import com.situ.web.service.ICourseService;
import com.situ.web.service.impl.CourseServiceImpl;
import com.situ.web.utils.JSONUtils;
import com.situ.web.utils.PageResult;
import com.situ.web.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 10:58
 */
@WebServlet("/course")
public class CourseServlet extends BaseServlet {
    private ICourseService courseService = new CourseServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CourseServlet");
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String credit = req.getParameter("credit");
        Course course = new Course(name, Integer.parseInt(credit));
        courseService.add(course);
        JSONUtils.toJSON(resp, Result.ok("添加成功"));
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        courseService.deleteById(Integer.parseInt(id));
//        JSONUtils.toJSON(resp, Result.ok("删除成功"));
        toJSON(resp, Result.ok("删除成功"));
    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        PageResult<Course> pageResult = courseService.selectByPage(Integer.parseInt(page), Integer.parseInt(limit));
        JSONUtils.toJSON(resp, pageResult);
    }
}
