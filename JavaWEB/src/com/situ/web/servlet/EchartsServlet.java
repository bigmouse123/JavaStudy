package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.vo.GenderCountVO;
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
 * @date 2025/2/13 13:52
 */
@WebServlet("/echarts")
public class EchartsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<GenderCountVO> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT gender AS 'name',count(*) AS 'value' FROM student GROUP BY gender";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int value = resultSet.getInt("value");
                GenderCountVO genderCountVO = new GenderCountVO(name, value);
                list.add(genderCountVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), list);
    }
}
