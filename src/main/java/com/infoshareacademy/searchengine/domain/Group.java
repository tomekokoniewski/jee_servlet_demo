package com.infoshareacademy.searchengine.domain;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    private int id;
    private String name;
    private List<User> users;

}
