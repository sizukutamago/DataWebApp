package com.sample.sample;

import com.sun.tools.corba.se.idl.constExpr.GreaterEqual;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/person")
public class MyPersonDataServlet extends BeanAutowiringFilterServlet {
    @Autowired
    private MyPersonDataDaoImpl dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = repository.getAllName();
        req.setAttribute("entities", list);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");

        List<MyPersonData> list = repository.findByNameLikeOrMailLike("%" + name + "%", "%" + mail + "%");
        req.setAttribute("entities", list);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
