package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tim.pizzApp.entity.Order;
@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Override
    public void save(Order order) {
        String sql ="INSERT INTO orders  VALUES (DEFAULT,?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getUserLogin(), order.getUserName(), order.getDeliveryAddress(),
                order.getPhone(), order.getOrder(), order.getNotice(), order.getPrice(), order.getStatus());
    }
}
