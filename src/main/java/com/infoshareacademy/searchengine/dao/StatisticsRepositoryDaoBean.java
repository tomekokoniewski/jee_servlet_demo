package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Statistics;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.StatisticsRepository;
import com.infoshareacademy.searchengine.repository.UsersRepository;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Stateless //stan EJB
public class StatisticsRepositoryDaoBean implements StatisticsRepositoryDao {
    @Override
    public void addStatistics(Statistics statisticsNew) {
        StatisticsRepository.getRepository().add(statisticsNew);
    }

    @Override
    public Statistics getStatisticsById(int id) {
        return null;
    }

    @Override
    public List<Statistics> getStatisticsList() {
        return StatisticsRepository.getRepository();
    }

    @Override
    public List<String> getStatisticsListToday() {
        List<String> statList = new ArrayList<>();
        LocalDate today = LocalDate.now();
        int i = 0;

        for (User user : UsersRepository.getRepository()) {
            StringBuilder stat = new StringBuilder();
            for (Statistics statistics : StatisticsRepository.getRepository()) {
                if ((statistics.getId() == user.getId()) && (statistics.getDate().equals(today))) {
                    i++;
                }
            }
            stat = stat.append("UsrId: " + user.getId() + " | " + user.getName() +
                    " " + user.getSurname() + " - pytano: <strong>" + i + "</strong> razy");
            statList.add(stat.toString());
            i = 0;
        }
        return statList;
    }
}