package com.infoshareacademy.searchengine.dao;


import com.infoshareacademy.searchengine.domain.Statistics;

import javax.ejb.Local;
import java.util.List;

@Local //EJB
public interface StatisticsRepositoryDao {

    void addStatistics(Statistics statistics);

    Statistics getStatisticsById(int id);

    List<Statistics> getStatisticsList();

    List<String> getStatisticsListToday();
}
