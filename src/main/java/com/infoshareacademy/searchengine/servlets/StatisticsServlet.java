package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/statistics")
public class StatisticsServlet extends HttpServlet {

    @EJB
    StatisticsRepositoryDao statisticsRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter prWr = resp.getWriter();
        prWr.println("<!DOCTYPE html>");
        prWr.println("<html>");
        prWr.println("<body>");

        for (String string : statisticsRepositoryDao.getStatisticsListToday()) {
            prWr.println("<p>" + string + "</p>");
        }
        prWr.println("</body>");
        prWr.println("</html>");
    }
}
