package ru.tim.pizzApp.dao;

import ru.tim.pizzApp.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();


}
