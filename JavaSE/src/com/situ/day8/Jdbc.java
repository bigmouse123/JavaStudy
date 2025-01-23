package com.situ.day8;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/20 20:50
 */
public class Jdbc {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        Driver driver = new Driver();
        //得到连接
        String url = "jdbc:mysql://localhost:3306/study";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "a200211080");
        Connection connect = driver.connect(url, properties);
        //执行sql
        String sql = "insert into stu values(1,'李',24,'男','青岛')";
        Statement statement = connect.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println((i > 0) ? "连接成功" : "连接失败");
        //关闭连接
        statement.close();
        connect.close();
    }
}
