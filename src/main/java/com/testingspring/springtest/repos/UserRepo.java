package com.testingspring.springtest.repos;

import com.testingspring.springtest.model.User;

import java.util.List;

public interface UserRepo {

    User save(User user);

    boolean delete(int id);

    List<User> getAll();
}