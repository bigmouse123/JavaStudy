package com.situ.web.dao.impl;

import com.situ.web.dao.ITeacherDao;
import com.situ.web.pojo.Teacher;
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
 * @date 2025/2/7 19:48
 */
public class TeacherDaoImpl implements ITeacherDao {
    @Override
    public List<Teacher> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Teacher> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,address from teacher";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                Teacher teacher = new Teacher(id, name, age, address);
                list.add(teacher);
            }
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Teacher selectById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Teacher teacher = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,age,address from teacher where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                teacher = new Teacher(id, name, age, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return teacher;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from teacher where id = ?";
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
    public void update(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        int id = teacher.getId();
        String name = teacher.getName();
        int age = teacher.getAge();
        String address = teacher.getAddress();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE teacher SET name = ?,age = ?,address = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, address);
            statement.setInt(4, id);
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
    public List<Teacher> selectByPage(int offset, int pageSize) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Teacher> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,age,address from teacher LIMIT ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                Teacher teacher = new Teacher(id, name, age, address);
                list.add(teacher);
            }
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public void add(Teacher teacher) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into teacher(name,age,address) values(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getName());
            statement.setInt(2, teacher.getAge());
            statement.setString(3, teacher.getAddress());
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
    public int selectTotalCount() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int totalCount = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) from teacher";
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
}
