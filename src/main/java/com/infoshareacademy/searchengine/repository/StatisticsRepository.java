package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.Statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsRepository {
    private static List<Statistics> statisticsRepository = new ArrayList<>();

    public static List<Statistics> getRepository() {
        return statisticsRepository;
    }
}
