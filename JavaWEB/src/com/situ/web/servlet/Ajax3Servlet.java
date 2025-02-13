package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.Area;
import com.situ.web.pojo.City;
import com.situ.web.pojo.Province;
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
 * @date 2025/2/13 10:56
 */
@WebServlet("/ajax3")
public class Ajax3Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax3Servlet");
        String method = req.getParameter("method");
        switch (method) {
            case "selectProvince":
                selectProvince(req, resp);
                break;
            case "selectCity":
                selectCity(req, resp);
                break;
            case "selectArea":
                selectArea(req, resp);
                break;
        }
    }

    private void selectArea(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Area> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id,name from tm_area where city_id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(req.getParameter("cityId")));
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Area area = new Area(id, name);
                list.add(area);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), list);
    }

    private void selectCity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<City> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id,name from tm_city where province_id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(req.getParameter("provinceId")));
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                City city = new City(id, name);
                list.add(city);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), list);
    }

    private void selectProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Province> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id,name from tm_province";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Province province = new Province(id, name);
                list.add(province);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), list);
    }
}
