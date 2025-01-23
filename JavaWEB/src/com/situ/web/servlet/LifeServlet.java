package com.situ.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/23 13:43
 */
@WebServlet("/life")
public class LifeServlet extends HttpServlet {

    public LifeServlet() {
        System.out.println("LifeServlet constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("LifeServlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LifeServlet");
    }

    @Override
    public void destroy() {
        System.out.println("LifeServlet destroy");
    }
}
