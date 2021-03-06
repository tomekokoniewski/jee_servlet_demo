package com.infoshareacademy.searchengine.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class User {
    private int id;
    private String name;
    private String surname;
    private String login;
    private int age;
    private Gender gender;
    private List<Group> groups;
}
