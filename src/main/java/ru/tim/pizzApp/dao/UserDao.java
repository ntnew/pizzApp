package ru.tim.pizzApp.dao;

import ru.tim.pizzApp.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    Object getById(int id);

    void delete(int id);

    void update(User user);

    List<User> findAll();


}
