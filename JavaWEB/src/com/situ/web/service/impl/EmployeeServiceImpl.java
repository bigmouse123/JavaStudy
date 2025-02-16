package com.situ.web.service.impl;

import com.situ.web.dao.IEmployeeDao;
import com.situ.web.dao.impl.EmployeeDaoImpl;
import com.situ.web.pojo.Employee;
import com.situ.web.pojo.query.EmployeeQuery;
import com.situ.web.service.IEmployeeService;
import com.situ.web.utils.PageResult;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/16 20:10
 */
public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public PageResult<Employee> selectByPage(EmployeeQuery employeeQuery) {
        List<Employee> employees = employeeDao.selectByPage(employeeQuery);
        Integer totalCount = employeeDao.selectTotalCount(employeeQuery);
        PageResult<Employee> pageResult = new PageResult<>(0, "", totalCount, employees);
        return pageResult;
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public Employee selectById(int id) {
        Employee employee = employeeDao.selectById(id);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            employeeDao.deleteById(Integer.parseInt(id));
        }
    }
}
