package com.situ.web.service;

import com.situ.web.pojo.Employee;
import com.situ.web.pojo.query.EmployeeQuery;
import com.situ.web.utils.PageResult;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/16 20:09
 */
public interface IEmployeeService {
    PageResult<Employee> selectByPage(EmployeeQuery employeeQuery);

    void deleteById(int id);

    void add(Employee employee);

    Employee selectById(int id);

    void update(Employee employee);

    void deleteAll(String[] ids);
}
