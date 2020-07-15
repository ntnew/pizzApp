package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tim.pizzApp.entity.Order;
import ru.tim.pizzApp.mapper.OrderMapper;
import ru.tim.pizzApp.mapper.UserMapper;

import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Override
    public void save(Order order) {
        String sql ="INSERT INTO orders  VALUES (DEFAULT,?, ?, ?, ?, ?, ?, ?, ?,  NOW())";
        jdbcTemplate.update(sql, order.getUserLogin(), order.getUserName(), order.getDeliveryAddress(),
                order.getPhone(), order.getOrder(), order.getNotice(), order.getPrice(), order.getStatus());
    }

    @Override
    public List<Order> getAllUserOrder(String userLogin) {
        String sql = "SELECT * FROM orders WHERE userLogin Like ?";
        return jdbcTemplate.query(sql, new OrderMapper(), userLogin);
    }

    @Override
    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderMapper());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM orders WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateStatus(Order order) {
        String sql = "UPDATE orders SET status=?, notice=? WHERE id=?";
        jdbcTemplate.update(sql, order.getStatus(), order.getNotice(), order.getId());

    }
}
