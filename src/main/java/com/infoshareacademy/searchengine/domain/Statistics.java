package com.infoshareacademy.searchengine.domain;

import java.time.LocalDate;

public class Statistics {
    private int id;
    private int quantity;
    private LocalDate date;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFrequency() {
        return quantity;
    }
    public void setFrequency(int frequency) {
        this.quantity = frequency;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
