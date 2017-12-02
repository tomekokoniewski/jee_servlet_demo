package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.UsersRepository;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Stateless //stan EJB
public class UsersRepositoryDaoBean implements UsersRepositoryDao, UsersRepositoryDaoRemote{

    @Override
    public void addUser(User user) {
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersList() {
        return UsersRepository.getRepository();
    }


    @Override
    public List<String> getUserNames() {


        return getUsersList().stream().map(User::getName).collect(Collectors.toList());
    }
}

