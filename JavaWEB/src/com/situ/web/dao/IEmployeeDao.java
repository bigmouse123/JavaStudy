package com.situ.web.dao;

import com.situ.web.pojo.Employee;
import com.situ.web.pojo.query.EmployeeQuery;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/16 20:13
 */
public interface IEmployeeDao {
    List<Employee> selectByPage(EmployeeQuery employeeQuery);

    Integer selectTotalCount(EmployeeQuery employeeQuery);

    void deleteById(int id);

    void add(Employee employee);

    Employee selectById(int id);

    void update(Employee employee);
}
