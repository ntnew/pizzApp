package ru.tim.pizzApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tim.pizzApp.dao.OrderDao;
import ru.tim.pizzApp.entity.Order;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    public OrderDao orderDao;
    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}