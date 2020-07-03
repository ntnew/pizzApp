package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tim.pizzApp.entity.Additive;
import ru.tim.pizzApp.mapper.AdditiveMapper;
import ru.tim.pizzApp.mapper.FoodMapper;

import java.util.List;
@Repository
public class AdditiveDaoImp implements AdditiveDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Additive> findAll() {
        String sql = "SELECT * FROM additives";
        return jdbcTemplate.query(sql, new AdditiveMapper());
    }

    @Override
    public Double findPriceByName(String additiveName) {
        String sql = "SELECT * FROM additives WHERE name LIKE ?";
        Additive additive = (Additive) jdbcTemplate.queryForObject(sql, new AdditiveMapper(), additiveName);
        return additive.getPrice();
    }
}
