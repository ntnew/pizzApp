package ru.tim.pizzApp.service;

import ru.tim.pizzApp.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> getAllUserOrder(String userLogin);

    List<Order> findAll ();
}
