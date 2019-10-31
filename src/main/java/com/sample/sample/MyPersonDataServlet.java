package com.sample.sample;

import com.sun.tools.corba.se.idl.constExpr.GreaterEqual;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/person")
public class MyPersonDataServlet extends BeanAutowiringFilterServlet {
    @Autowired
    private MyPersonDataDaoImpl dao;

    @Autowired
    private Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MyPersonData> list = dao.getAllEntity();
        req.setAttribute("msg", "please type my person data");
        req.setAttribute("name", "");
        req.setAttribute("mail", "");
        req.setAttribute("age", "");
        req.setAttribute("entities", list);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        int age;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException e) {
            age = 0;
        }

        MyPersonData entity = new MyPersonData(name, mail, age);
        Set<ConstraintViolation<MyPersonData>> result = validator.validate((MyPersonData)entity);

        if (result.isEmpty()) {
            dao.addEntity(entity);
            resp.sendRedirect("/person");
        } else {
            String msg = "<pre>";
            for(ConstraintViolation<MyPersonData> viola : result) {
                msg += viola.getPropertyPath() + ":" + viola.getMessage() + "\n";
            }

            msg += "</pre>";
            req.setAttribute("msg", msg);
            req.setAttribute("name", name);
            req.setAttribute("mail", mail);
            req.setAttribute("age", age);
            req.setAttribute("entities", dao.getAllEntity());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
