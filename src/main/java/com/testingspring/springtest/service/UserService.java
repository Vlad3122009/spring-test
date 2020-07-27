package com.testingspring.springtest.service;


import com.testingspring.springtest.model.User;

import com.testingspring.springtest.repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.testingspring.springtest.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {
    private final UserRepo repository;

    public UserService(UserRepo repo){
        this.repository = repo;
    }

    public User create(User user){return repository.save(user);}

    public void delete(int id){checkNotFoundWithId(repository.delete(id),id);}

    public List<User> getAll(){return repository.getAll();}

    public void update(User user){checkNotFoundWithId(repository.save(user),user.getId());}
}
