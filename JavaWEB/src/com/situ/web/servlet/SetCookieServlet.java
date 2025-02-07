package com.situ.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 11:16
 */
@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("goods", "IPhone1");
        Cookie cookie2 = new Cookie("name", "IPhone2");
        cookie1.setMaxAge(10 * 60);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
