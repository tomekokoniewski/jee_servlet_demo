package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.Local;
import java.util.List;

@Local //EJB
public interface UsersRepositoryDao {

    void addUser(User user);
    User getUserById(int id);
    User getUserByLogin(String login);
    List<User> getUsersList();


}
