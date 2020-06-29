package ru.tim.pizzApp.service;

import ru.tim.pizzApp.entity.User;


import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {
    void save(User user);

    Object getById(int id);

    User getByUserName(String username);

    void delete(int id);

    void update(User user);

    List<User> findAll();

    User getByLogin(String login);
}
