package com.situ.web.dao.impl;

import com.situ.web.dao.ICourseDao;
import com.situ.web.pojo.Course;
import com.situ.web.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 11:27
 */
public class CourseDaoImpl implements ICourseDao {
    @Override
    public List<Course> selectByPage(Integer offset, Integer limit) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Course> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,credit from course LIMIT ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int credit = resultSet.getInt("credit");
                Course course = new Course(id, name, credit);
                list.add(course);
            }
            for (Course course : list) {
                System.out.println(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer selectTotalCount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int totalCount = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) from course";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                totalCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return totalCount;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from course where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, null);
        }
    }

    @Override
    public void add(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into course(name,credit) values(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, course.getName());
            statement.setInt(2, course.getCredit());
            int count = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, null);
        }
    }
}
