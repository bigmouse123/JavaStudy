package com.situ.web.servlet;


import com.situ.web.pojo.Employee;
import com.situ.web.pojo.query.EmployeeQuery;
import com.situ.web.service.IEmployeeService;
import com.situ.web.service.impl.EmployeeServiceImpl;
import com.situ.web.utils.JSONUtils;
import com.situ.web.utils.PageResult;
import com.situ.web.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/16 19:38
 */
@WebServlet("/employee")
public class EmployeeServlet extends BaseServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectByPage":
                selectByPage(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "selectById":
                selectById(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "deleteAll":
                deleteAll(req, resp);
                break;
        }
    }

    private void deleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] ids = req.getParameterValues("ids[]");
        employeeService.deleteAll(ids);
        toJSON(resp, Result.ok("删除成功"));
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        Employee employee = new Employee(Integer.parseInt(id), name, Double.parseDouble(salary));
        employeeService.update(employee);
        JSONUtils.toJSON(resp, Result.ok("编辑成功"));
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.selectById(Integer.parseInt(id));
        JSONUtils.toJSON(resp, Result.ok(employee));
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        Employee employee = new Employee(name, Double.parseDouble(salary));
        employeeService.add(employee);
        JSONUtils.toJSON(resp, Result.ok("添加成功"));
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        employeeService.deleteById(Integer.parseInt(id));
        toJSON(resp, Result.ok("删除成功"));
    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String minSalary = req.getParameter("minSalary");
        String maxSalary = req.getParameter("maxSalary");
        System.out.println("minSalary=" + minSalary);
        System.out.println("maxSalary=" + maxSalary);
        EmployeeQuery employeeQuery = new EmployeeQuery(Integer.parseInt(page), Integer.parseInt(limit), name, salary, minSalary, maxSalary);
        PageResult<Employee> pageResult = employeeService.selectByPage(employeeQuery);
        JSONUtils.toJSON(resp, pageResult);

    }
}
