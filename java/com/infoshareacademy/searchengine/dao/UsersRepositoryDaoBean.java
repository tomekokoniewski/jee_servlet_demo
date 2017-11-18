package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.UsersRepository;

import java.util.List;

public class UsersRepositoryDaoBean implements UsersRepositoryDao{

    @Override
    public void addUser(User user) {
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id){
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }


    @Override
    public User getUserByLogin(String login){
        List<User> userList = UsersRepository.getRepository();
        for (User user : userList){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }


    @Override
    public List<User> getUsersList(){return UsersRepository.getRepository();}




}

