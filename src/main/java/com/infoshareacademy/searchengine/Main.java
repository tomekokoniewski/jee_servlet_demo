package com.infoshareacademy.searchengine;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");


        UsersRepositoryDaoBean usersRepositoryDaoBean = new UsersRepositoryDaoBean();
        for (User user : usersRepositoryDaoBean.getUsersList()){
            System.out.println(user.getId()+" "+user.getName());
        }
    }
}
