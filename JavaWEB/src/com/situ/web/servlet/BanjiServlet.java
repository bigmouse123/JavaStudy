package com.situ.web.servlet;

import com.situ.web.dao.IBanjiDao;
import com.situ.web.dao.impl.BanjiDaoImpl;
import com.situ.web.pojo.Banji;
import com.situ.web.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/23 12:00
 */
@WebServlet("/banji")
public class BanjiServlet extends HttpServlet {

    private IBanjiDao iBanjiDao = new BanjiDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BanjiServlet");
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectAll";
        }
        switch (method) {
            case "selectAll":
                selectAll(req, resp);
                break;
            case "deleteById":
                deleteById(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "toBanjiAdd":
                toBanjiAdd(req, resp);
                break;
            case "selectById":
                selectById(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }

    }


    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Banji> list = iBanjiDao.selectAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("banji_list.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        iBanjiDao.deleteById(id);
        resp.sendRedirect("/banji");
    }

    private void toBanjiAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("toBanjiAdd");
        req.getRequestDispatcher("banji_add.jsp").forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Banji banji = new Banji();
        banji.setName(req.getParameter("name"));
        banji.setAddress(req.getParameter("address"));
        iBanjiDao.add(banji);
        resp.sendRedirect("/banji");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        Banji banji = new Banji();
        banji.setId(Integer.parseInt(id));
        banji.setName(name);
        banji.setAddress(address);
        iBanjiDao.update(banji);
        resp.sendRedirect("/banji");
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Banji banji = iBanjiDao.selectById(id);
        req.setAttribute("banji", banji);
        req.getRequestDispatcher("banji_update.jsp").forward(req, resp);
    }
}
