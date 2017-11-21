package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServle extends HttpServlet {

    @EJB //@Inject

    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));

      //  UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean(); //ważne z jednej str Dao, z drugiej Bean, muszę DAO jako interface - JEE pracuje na interfeace

        User user = usersRepositoryDao.getUserById(id);

        if (user == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println("uzytk nie znaleziony");
            return;
        }

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(user.getName());
    }
}

//http://localhost:8080/find-user-by-id?id=1
//http://localhost:8080/find-user-by-id?id=100 --uzytk nie znaleziony


/*
//EJB:
stan dodajemy na klasie
 zasieg       na interfejsiw
 */