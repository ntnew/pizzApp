package ru.tim.pizzApp.mapper;


import org.springframework.jdbc.core.RowMapper;
import ru.tim.pizzApp.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setUserLogin(resultSet.getString("userLogin"));
        order.setUserName(resultSet.getString("userName"));
        order.setDeliveryAddress(resultSet.getString("deliveryAddress"));
        order.setPhone(resultSet.getString("phone"));
        order.setOrder(resultSet.getString("order"));
        order.setNotice(resultSet.getString("notice"));
        order.setStatus(resultSet.getString("status"));
        order.setPrice(resultSet.getDouble("price"));
        return order;
    }
}
