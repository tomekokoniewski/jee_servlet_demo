package com.infoshareacademy.searchengine;

import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDaoBean;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.Statistics;
import com.infoshareacademy.searchengine.domain.User;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");


        UsersRepositoryDaoBean usersRepositoryDaoBean = new UsersRepositoryDaoBean();
        for (User user : usersRepositoryDaoBean.getUsersList()) {
            System.out.println(user.getId() + " " + user.getName());
        }

        //symulacja zapytania o usera
        User wynik = usersRepositoryDaoBean.getUserById(1); //w serwlecie realizowane jest to przez interface UsersRepositoryDao usersRepositoryDao
        System.out.println("zapytałeś o usr: " + wynik.getName() + " " + wynik.getSurname());

        StatisticsRepositoryDaoBean statisticsRepositoryDaoBean = new StatisticsRepositoryDaoBean();

        //zbudowanie historii statystyk

        Statistics statistics0 = new Statistics();
        statistics0.setId(1);
        statistics0.setFrequency(1);
//        Date input = new Date();
        //       LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        statistics0.setDate(LocalDate.now());
        statisticsRepositoryDaoBean.addStatistics(statistics0);


        for (int j = 0; j < 6; j++) {
            for (int i = 1; i < 4; i++) {
                Statistics statistics = new Statistics();
                statistics.setId(i);
                statistics.setFrequency(1);
                Date input = new Date();
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                statistics.setDate(date);

                statisticsRepositoryDaoBean.addStatistics(statistics);
            }
        }
        //-----------------------------
        LocalDate today = LocalDate.now();
        System.out.println(today);

        for (Statistics statistics1 : statisticsRepositoryDaoBean.getStatisticsList()) {
            System.out.println(statistics1.getId() + " " + statistics1.getFrequency() + " " + statistics1.getDate().toString());
        }

        for (String statistics1 : statisticsRepositoryDaoBean.getStatisticsListToday()) {
            System.out.println(statistics1);
        }

    }
}
