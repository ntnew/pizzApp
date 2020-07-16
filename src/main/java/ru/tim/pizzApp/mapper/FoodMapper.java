package ru.tim.pizzApp.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tim.pizzApp.entity.Food;
import ru.tim.pizzApp.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Food food  = new Food();
        food.setId(resultSet.getInt("id"));
        food.setName(resultSet.getString("name"));
        food.setDescription(resultSet.getString("description"));
        food.setPrice(resultSet.getDouble("price"));
        food.setWeight(resultSet.getInt("weight"));
        food.setType(resultSet.getString("type"));
        food.setImage(resultSet.getString("image"));
        return food;
    }
}
