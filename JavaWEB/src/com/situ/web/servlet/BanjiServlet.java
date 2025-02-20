package com.situ.web.servlet;

import com.situ.web.pojo.Banji;
import com.situ.web.pojo.User;
import com.situ.web.service.IBanjiService;
import com.situ.web.service.impl.BanjiServiceImpl;
import com.situ.web.utils.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/23 12:00
 */
@WebServlet("/banji")
public class BanjiServlet extends HttpServlet {

    private IBanjiService banjiService = new BanjiServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BanjiServlet");

        req.setCharacterEncoding("utf-8");
//        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
//        if(user == null) {
//            resp.sendRedirect("login.jsp");
//            return;
//        }

        String method = req.getParameter("method");
        if (method == null || method.equals("")) {
            method = "selectByPage";
        }
        switch (method) {
            case "selectAll":
                selectAll(req, resp);
                break;
            case "selectByPage":
                selectByPage(req, resp);
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
            case "toBanjiUpdate":
                toBanjiUpdate(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }

    }


    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Banji> list = banjiService.selectAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("banji_list.jsp").forward(req, resp);
    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNo = req.getParameter("pageNo");
        String pageSize = req.getParameter("pageSize");
        if (pageNo == null || pageNo.equals("")) {
            pageNo = "1";
        }
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "5";
        }
        PageInfo<Banji> pageInfo = banjiService.selectByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        System.out.println(pageInfo);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/banji_list.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        banjiService.deleteById(id);
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
        banjiService.add(banji);
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
        banjiService.update(banji);
        resp.sendRedirect("/banji");
    }

    private void toBanjiUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Banji banji = banjiService.selectById(id);
        req.setAttribute("banji", banji);
        req.getRequestDispatcher("/banji_update.jsp").forward(req, resp);
    }
}
