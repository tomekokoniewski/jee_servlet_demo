package com.infoshareacademy.searchengine.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/welcome-user")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("name")==null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        req.getSession().setAttribute("name", req.getParameter("name"));
        req.getSession().setAttribute("salary", req.getParameter("salary"));

        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("test", req.getParameter("name"));

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");

        writer.println("Hello <br>"+req.getParameter("name")+"</br>");
        writer.println("</body>");
        writer.println("</html>");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/test.jsp");
        requestDispatcher.forward(req, resp);


    }
}


//http://localhost:8080/welcome-user?name=Tomek
//http://localhost:8080/welcome-user --pusta str --f12, network, odświeżyć str - ststus powiniem byc 400 (bad req)

