package com.situ.day9;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/21 10:54
 */
public class JDBCDemo {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?useSSL=false&useUnicode=true&allowPublicKeyRetrieval=true&characterEncoding=utf8&serverTimezone=GMT%2b8", "root", "a200211080");
            //3.写sql语句
            String sql = "SELECT id,name,age,gender from student";
            //4.创建statement
            statement = connection.createStatement();
            //5.执行sql语句
            resultSet = statement.executeQuery(sql);
            List<Student> list = new ArrayList<Student>();
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test2() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?useSSL=false&useUnicode=true&allowPublicKeyRetrieval=true&characterEncoding=utf8&serverTimezone=GMT%2b8", "root", "a200211080");
            //3.写sql语句
            String sql = "SELECT id,name,age,gender from student";
            //4.创建statement
//            statement = connection.createStatement();
            statement = connection.prepareStatement(sql);
            //5.执行sql语句
//            resultSet = statement.executeQuery(sql);
            resultSet = statement.executeQuery();
            List<Student> list = new ArrayList<Student>();
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,age,gender from student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Student> list = new ArrayList<Student>();
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
    }

    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into student(id,name,age,gender) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4);
            statement.setString(2, "张");
            statement.setInt(3, 24);
            statement.setString(4, "男");
            int count = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, null);
        }
    }

    @Test
    public void testDelete() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from student where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4);
            int count = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, null);
        }
    }

    @Test
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE student SET name = ?,age = ?,gender = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "张");
            statement.setInt(2, 24);
            statement.setString(3, "男");
            statement.setInt(4, 1);
            int count = statement.executeUpdate();
            System.out.println(statement);
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, null);
        }
    }

    @Test
    public void testLike() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,age,gender from student where name like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "张%");
            resultSet = statement.executeQuery();
            List<Student> list = new ArrayList<Student>();
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
    }
}
