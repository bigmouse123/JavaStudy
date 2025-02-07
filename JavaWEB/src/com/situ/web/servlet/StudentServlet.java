package com.situ.web.servlet;

import com.situ.web.pojo.Student;
import com.situ.web.service.IStudentService;
import com.situ.web.service.impl.StudentServiceImpl;
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
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private IStudentService studentService = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet");
        req.setCharacterEncoding("utf-8");

//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
//        if(user == null) {
//            resp.sendRedirect("login.jsp");
//            return;
//        }

        // http://localhost:8080/JavaWeb/student?method=selectAll
        // http://localhost:8080/JavaWeb/student?method=deleteById&id=1
        // http://localhost:8080/JavaWeb/student?method=add
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
            case "toStudentAdd":
                toStudentAdd(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "toStudentUpdate":
                toStudentUpdate(req, resp);
                break;

        }

    }


    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentService.selectAll();
        //把list数据交给jsp页面进行展示
        //把list数据放道req里面
        req.setAttribute("list", list);
        //转发到student_list.jsp页面进行展示
        req.getRequestDispatcher("student_list.jsp").forward(req, resp);
    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        if (pageNo == null || pageNo.equals("")) {
            pageNo = "1";
        }
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "5";
        }
        PageInfo<Student> pageInfo = studentService.selectByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        System.out.println(pageInfo);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteStudentServlet");
        String id = req.getParameter("id");
        studentService.deleteById(Integer.parseInt(id));
        //删除之后重定向
        resp.sendRedirect("/student");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setName(req.getParameter("name"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        student.setGender(req.getParameter("gender"));
        studentService.add(student);
        resp.sendRedirect("/student");
    }

    private void toStudentAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("toStudentAdd");
        req.getRequestDispatcher("student_add.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("update");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        Student student = new Student(id, name, age, gender);
        studentService.update(student);
        resp.sendRedirect("/student");
    }

    private void toStudentUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("toStudentUpdate");
        String id = req.getParameter("id");
        Student student = studentService.selectById(Integer.parseInt(id));
        req.setAttribute("student", student);
        req.getRequestDispatcher("/student_update.jsp").forward(req, resp);
    }
}
