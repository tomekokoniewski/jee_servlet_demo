package com.infoshareacademy.searchengine.cdibeans;


import com.infoshareacademy.searchengine.domain.Gender;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MaxPulseBean implements MaxPulse{
    @Override
    public double Pulse(int age, Gender gender) {
        if(gender.equals(Gender.MAN)){
            return 202-(0.55*age);
        }
        else
        return 216-(1.09)*age;
    }
/*
    @Override
    public double womanPulse(int age) {
        return 216-(1.09)*age;
    }

    @Override
    public double manPulse(int age) {
        return 202-(0.55*age);
    }
*/



}
