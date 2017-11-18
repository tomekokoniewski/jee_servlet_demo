package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    private static List<User> usersRepository = new ArrayList<>();

    public static List<User> getRepository() {
        if (usersRepository.size() == 0) {
            fillRepositoryWithDefaults();
        }
        return usersRepository;
    }

    private static void fillRepositoryWithDefaults() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Jan");
        user1.setSurname("Kowalski");
        user1.setLogin("janko");
        user1.setAge(21);
        usersRepository.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Adam");
        user2.setSurname("Nowak");
        user2.setLogin("ano");
        user2.setAge(20);
        usersRepository.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Anna");
        user3.setSurname("Michalczuk");
        user3.setLogin("anmi");
        user3.setAge(20);
        usersRepository.add(user3);
    }
}
