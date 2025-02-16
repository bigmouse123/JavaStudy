package com.situ.web.dao.impl;

import com.situ.web.dao.IEmployeeDao;
import com.situ.web.pojo.Employee;
import com.situ.web.pojo.query.EmployeeQuery;
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
 * @date 2025/2/16 20:13
 */
public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public List<Employee> selectByPage(EmployeeQuery employeeQuery) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> list = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,salary FROM employee WHERE 1=1";
            List<Object> params = new ArrayList<>();
            String queryName = employeeQuery.getName();
            if (queryName != null && !"".equals(queryName)) {
                sql += " and name like ?";
                params.add("%" + queryName + "%");
            }
            String minSalary = employeeQuery.getMinSalary();
            String maxSalary = employeeQuery.getMaxSalary();
            if ((minSalary != null && !"".equals(minSalary))
                    && (maxSalary != null && !"".equals(maxSalary))) {
                sql += " and salary between " + minSalary + " and " + maxSalary;
            }
            sql += " LIMIT ?,?";
            int offset = (employeeQuery.getPage() - 1) * employeeQuery.getLimit();
            params.add(offset);
            params.add(employeeQuery.getLimit());
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            System.out.println("sql=" + sql);
            System.out.println("statement=" + statement);
            resultSet = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                Employee employee = new Employee(id, name, salary);
                list.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public Integer selectTotalCount(EmployeeQuery employeeQuery) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int totalCount = 0;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT COUNT(*) FROM employee WHERE 1=1";
            List<Object> params = new ArrayList<>();
            String queryName = employeeQuery.getName();
            if (queryName != null && !"".equals(queryName)) {
                sql += " and name like ?";
                params.add("%" + queryName + "%");
            }
            String minSalary = employeeQuery.getMinSalary();
            String maxSalary = employeeQuery.getMaxSalary();
            if ((minSalary != null && !"".equals(minSalary))
                    && (maxSalary != null && !"".equals(maxSalary))) {
                sql += " and salary between " + minSalary + " and " + maxSalary;
            }
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                totalCount = resultSet.getInt(1);
                System.out.println("totalCount=" + totalCount);
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
            String sql = "delete from employee where id = ?";
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
    public void add(Employee employee) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into employee(name,salary) values(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setDouble(2, employee.getSalary());
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
    public Employee selectById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id,name,salary from employee where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Double salary = resultSet.getDouble("salary");
                employee = new Employee(id, name, salary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = null;
        PreparedStatement statement = null;
        int id = employee.getId();
        String name = employee.getName();
        double salary = employee.getSalary();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE employee SET name = ?,salary = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, salary);
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
