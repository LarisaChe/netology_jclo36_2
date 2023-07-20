package ru.netology.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    public UserRepository() {
    }

    private static HashMap<String, List<Authorities>> usersWithAuthorities = new HashMap<>();

    {
        usersWithAuthorities.put("Peter", new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        usersWithAuthorities.put("John", new ArrayList<>(Arrays.asList(Authorities.READ)));
        usersWithAuthorities.put("James", new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE)));
        usersWithAuthorities.put("Thomas", new ArrayList<>());
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return usersWithAuthorities.getOrDefault(user, new ArrayList<>());
    }
}
