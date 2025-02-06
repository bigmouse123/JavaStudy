package com.situ.web.dao.impl;

import com.situ.web.dao.IBanjiDao;
import com.situ.web.pojo.Banji;
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
 * @date 2025/2/4 3:45
 */
public class BanjiDaoImpl implements IBanjiDao {
    @Override
    public List<Banji> selectAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Banji> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,address from banji";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                Banji banji = new Banji(id, name, address);
                list.add(banji);
            }
            for (Banji banji : list) {
                System.out.println(banji);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from banji where id = ?";
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
    public void add(Banji banji) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into banji(name,address) values(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, banji.getName());
            statement.setString(2, banji.getAddress());
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
    public Banji selectById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Banji banji = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,address from banji where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                banji = new Banji(id, name, address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return banji;
    }

    @Override
    public void update(Banji banji) {
        Connection connection = null;
        PreparedStatement statement = null;
        int id = banji.getId();
        String name = banji.getName();
        String address = banji.getAddress();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE banji SET name = ?,address = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, address);
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
