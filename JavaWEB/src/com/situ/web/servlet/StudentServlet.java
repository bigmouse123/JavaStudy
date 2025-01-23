package com.situ.web.servlet;

import com.situ.web.pojo.Student;
import com.situ.web.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/23 12:00
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("StudentServlet");
        // http://localhost:8080/JavaWeb/student?method=selectAll
        // http://localhost:8080/JavaWeb/student?method=deleteById&id=1
        // http://localhost:8080/JavaWeb/student?method=add
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectAll";
        }
        switch (method) {
            case "selectAll":
                selectAll(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                break;
        }

    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,age,gender from student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            list = new ArrayList<Student>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id, name, age, gender);
                list.add(student);
            }
            for (Student student : list) {
                System.out.println(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        //把list数据交给jsp页面进行展示
        //把list数据当道req里面
        req.setAttribute("list", list);
        //转发到student_list.jsp页面进行展示
        req.getRequestDispatcher("student_list.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteStudentServlet");
        String id = req.getParameter("id");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from student where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            int count = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, null);
        }
        //删除之后重定向
        resp.sendRedirect("/student?method=deleteById");
    }
}
