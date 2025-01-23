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
 * @date 2025/1/23 15:14
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("DeleteStudentServlet");
//        String id = req.getParameter("id");
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection = JDBCUtils.getConnection();
//            String sql = "delete from student where id = ?";
//            statement = connection.prepareStatement(sql);
//            statement.setInt(1, Integer.parseInt(id));
//            int count = statement.executeUpdate();
//            System.out.println(statement);
//            System.out.println(count);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            JDBCUtils.close(connection, statement, null);
//        }
//        //删除之后重定向
//        resp.sendRedirect("/student");
//    }
}
