package ru.tim.pizzApp.service;

import ru.tim.pizzApp.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
