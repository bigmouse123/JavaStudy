package com.situ.web.servlet;

import com.situ.web.pojo.User;
import com.situ.web.service.IUserService;
import com.situ.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 13:56
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private IUserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        switch (method) {
            case "login":
                login(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
//        session.removeAttribute("user");
        resp.sendRedirect("/login.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = userService.login(name, password);
        System.out.println(user);
        if (user == null) {
            resp.sendRedirect("/fail.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/");
        }

    }
}
