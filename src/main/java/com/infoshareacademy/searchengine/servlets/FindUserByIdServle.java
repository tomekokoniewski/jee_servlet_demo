package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.cdibeans.MaxPulseBean;
import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Statistics;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet("/find-user-by-id")
public class FindUserByIdServle extends HttpServlet {


    //@Inject
    @EJB
    UsersRepositoryDao usersRepositoryDao;
    @EJB
    StatisticsRepositoryDao statisticsRepositoryDao;

    @Inject
    MaxPulseBean maxPulseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));
        //  UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean(); //ważne z jednej str Dao, z drugiej Bean, muszę DAO jako interface - JEE pracuje na interfeace

        User user = usersRepositoryDao.getUserById(id);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter prWr = resp.getWriter();
        prWr.println("<!DOCTYPE html>");
        prWr.println("<html>");
        prWr.println("<body>");

        if (user == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            prWr.println("uzytk nie znaleziony");
            return;
        }

        prWr.println("<p>Użytkownik o id=" + id + " to: " + user.getName() + "</p>");
        prWr.println("Puls max "+maxPulseBean.Pulse(user.getAge(),user.getGender()));

        Statistics statistics = new Statistics();
        statistics.setId(id);
        statistics.setFrequency(1);
        Date input = new Date();
        LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        statistics.setDate(date);

        statisticsRepositoryDao.addStatistics(statistics);
        int i = 0;
        for (Statistics statistics1 : statisticsRepositoryDao.getStatisticsList()) {
            if (statistics1.getId() == id) {
                i++;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        prWr.println("<p>Do " + timeStamp + "\n zapytano o użytkownika " + user.getName() + " <strong>" + i + "</strong> razy</p>");
        prWr.println("<p><a href='http://localhost:8080/statistics'>Dzisiejsze statystyki zapytań o użytkowników</a></p>");

        prWr.println("</body>");
        prWr.println("</html>");
    }
}

//http://localhost:8080/find-user-by-id?id=1
//http://localhost:8080/find-user-by-id?id=100 --uzytk nie znaleziony


/*
//EJB:
stan dodajemy na klasie
 zasieg       na interfejsiw
 */