package com.testingspring.springtest.repos;

import com.testingspring.springtest.model.User;

public interface UserRepo {

    User save(User user);

    boolean delete(int id);
}
