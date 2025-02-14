package com.situ.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 23:02
 */
public class BaseServlet extends HttpServlet {
    public void toJSON(HttpServletResponse resp, Object object) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(), object);
    }
}
