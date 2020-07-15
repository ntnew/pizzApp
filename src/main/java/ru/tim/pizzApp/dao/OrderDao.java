package ru.tim.pizzApp.dao;

import ru.tim.pizzApp.entity.Order;
import ru.tim.pizzApp.entity.User;

import java.util.List;

public interface OrderDao {

    void save(Order order);

    List<Order> getAllUserOrder(String userLogin);

    List<Order> findAll ();

    void deleteById(int id);

    void updateStatus(Order order);
}
