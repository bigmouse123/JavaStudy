package com.situ.web.servlet;

import com.situ.web.pojo.Teacher;
import com.situ.web.service.ITeacherService;
import com.situ.web.service.impl.TeacherServiceImpl;
import com.situ.web.utils.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/23 12:00
 */
@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

    private ITeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TeacherServlet");
        req.setCharacterEncoding("utf-8");
        // http://localhost:8080/JavaWeb/teacher?method=selectAll
        // http://localhost:8080/JavaWeb/teacher?method=deleteById&id=1
        // http://localhost:8080/JavaWeb/teacher?method=add
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectAll":
                selectAll(req, resp);
                break;
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "toTeacherAdd":
                toTeacherAdd(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "toTeacherUpdate":
                toTeacherUpdate(req, resp);
                break;

        }

    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        if (pageNo == null || pageNo == "") {
            pageNo = "1";
        }
        if (pageSize == null || pageSize == "") {
            pageSize = "5";
        }
        PageInfo<Teacher> pageInfo = teacherService.selectByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        System.out.println(pageInfo);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/teacher_list.jsp").forward(req, resp);
    }


    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> list = teacherService.selectAll();
        //把list数据交给jsp页面进行展示
        //把list数据放道req里面
        req.setAttribute("list", list);
        //转发到teacher_list.jsp页面进行展示
        req.getRequestDispatcher("teacher_list.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteTeacherServlet");
        String id = req.getParameter("id");
        teacherService.deleteById(Integer.parseInt(id));
        //删除之后重定向
        resp.sendRedirect("/teacher");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        System.out.println("AddTeacherServlet");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setAddress(address);
        teacherService.add(teacher);
        resp.sendRedirect("/teacher");
    }

    private void toTeacherAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("toTeacherAdd");
        req.getRequestDispatcher("teacher_add.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("update");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        Teacher teacher = new Teacher(id, name, age, address);
        teacherService.update(teacher);
        resp.sendRedirect("/teacher");
    }

    private void toTeacherUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("toTeacherUpdate");
        String id = req.getParameter("id");
        Teacher teacher = teacherService.selectById(Integer.parseInt(id));
        req.setAttribute("teacher", teacher);
        req.getRequestDispatcher("/teacher_update.jsp").forward(req, resp);
    }
}
