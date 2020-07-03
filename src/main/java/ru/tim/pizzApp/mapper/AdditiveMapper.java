package ru.tim.pizzApp.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tim.pizzApp.entity.Additive;
import ru.tim.pizzApp.entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdditiveMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Additive additive = new Additive();
        additive.setId(resultSet.getInt("id"));
        additive.setName(resultSet.getString("name"));
        additive.setPrice(resultSet.getDouble("price"));
        additive.setWeight(resultSet.getInt("weight"));
        return additive;
    }
}
