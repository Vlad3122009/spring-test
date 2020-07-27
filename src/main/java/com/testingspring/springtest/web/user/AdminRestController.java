package com.testingspring.springtest.web.user;

import com.testingspring.springtest.model.User;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminRestController extends AbstractUserController {

    public List<User> getAll() {
        return super.getAll();
    }

    public User create(User user) {
        return super.create(user);
    }

    public void delete(int id) {
        super.delete(id);
    }

    public void update(User user, int id) {
        super.update(user, id);
    }
}
