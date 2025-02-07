package com.situ.web.dao.impl;

import com.situ.web.dao.IUserDao;
import com.situ.web.pojo.User;
import com.situ.web.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 14:06
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User login(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,password from users where name = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                user = new User(id, username, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return user;
    }
}
