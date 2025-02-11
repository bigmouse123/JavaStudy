package com.situ.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/11 15:35
 */
@WebServlet("/ajax1")
public class Ajax1Servlet extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Ajax1Servlet");
//    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Ajax1Servlet doGet");
//        String name = req.getParameter("name");
//        System.out.println(name);
//
//        //转义 {"name":"李四","age":23}
//        resp.setContentType("text/html;charSet=utf-8");
//        resp.getWriter().write("{\"name\":\"李四1\",\"age\":24}");
//    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Ajax1Servlet doPost");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        String name = req.getParameter("name");
//        System.out.println(name);
//
//        resp.setContentType("text/html;charSet=utf-8");
//        resp.getWriter().write("{\"name\":\"李四2\",\"age\":24}");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax1Servlet doGet");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("name= " + name + " age= " + age);

        //{"name":"李四a","age":24}{'name':'李四a','age':24}
        String json = "{\"name\":\"李四a\",\"age\":24}";
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax1Servlet doPost");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("name= " + name + " age= " + age);

        String json = "{\"name\":\"李四b\",\"age\":25}";
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write(json);
    }
}
