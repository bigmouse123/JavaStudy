package com.situ.web.dao.impl;

import com.situ.web.dao.ICourseDao;
import com.situ.web.pojo.Course;
import com.situ.web.pojo.query.CourseQuery;
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
    public List<Course> selectByPage(CourseQuery courseQuery) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Course> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,credit from course WHERE 1=1";
            List<Object> params = new ArrayList<>();
            String queryName = courseQuery.getName();
            if (queryName != null && !"".equals(queryName)) {
                sql += " AND name LIKE ?";
                params.add("%" + queryName + "%");
            }
            String queryCredit = courseQuery.getCredit();
            if (queryCredit != null && !"".equals(queryCredit)) {
                sql += " AND credit = ?";
                params.add(queryCredit);
            }
            System.out.println("queryName:" + queryName);
            System.out.println("queryCredit:" + queryCredit);
            sql += " LIMIT ?,?";
            int offset = (courseQuery.getPage() - 1) * courseQuery.getLimit();
            params.add(offset);
            params.add(courseQuery.getLimit());
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int credit = Integer.parseInt(resultSet.getString("credit"));
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
    public Integer selectTotalCount(CourseQuery courseQuery) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int totalCount = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) FROM course WHERE 1=1";
            List<Object> params = new ArrayList<>();
            String queryName = courseQuery.getName();
            if (!"".equals(queryName)) {
                sql += " AND name LIKE ?";
                params.add("%" + queryName + "%");
            }
            String queryCredit = courseQuery.getCredit();
            if (!"".equals(queryCredit)) {
                sql += " AND credit = ?";
                params.add(queryCredit);
            }
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
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

    @Override
    public Course selectById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Course course = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,credit from course where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer credit = resultSet.getInt("credit");
                course = new Course(id, name, credit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return course;
    }

    @Override
    public void update(Course course) {
        Connection connection = null;
        PreparedStatement statement = null;
        int id = course.getId();
        String name = course.getName();
        int credit = course.getCredit();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE course SET name = ?,credit = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, credit);
            statement.setInt(3, id);
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
