package com.testingspring.springtest.web.user;

import com.testingspring.springtest.model.User;
import com.testingspring.springtest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.testingspring.springtest.util.ValidationUtil.assureIdConsistent;
import static com.testingspring.springtest.util.ValidationUtil.checkNew;

public class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public User create(User user){
        log.info("create {}", user);
        checkNew(user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user,int id) {
        log.info("update {} with id={}", user, id);
        assureIdConsistent(user, id);
        service.update(user);
    }

    public List<User> getAll(){
        log.info("getAll");
        return service.getAll();
    }
}
