package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tim.pizzApp.entity.Food;
import ru.tim.pizzApp.mapper.FoodMapper;
import ru.tim.pizzApp.mapper.UserMapper;

import java.util.List;

@Repository
public class FoodDaoImp implements FoodDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Override
    public List<Food> findAll() {
        String sql = "SELECT * FROM food";
        return jdbcTemplate.query(sql, new FoodMapper());
    }

    @Override
    public List<Food> findPizza() {
        String sql = "SELECT * FROM food WHERE type = 'pizza'";
        return jdbcTemplate.query(sql, new FoodMapper());
    }

    @Override
    public List<Food> findDrinks() {
        String sql = "SELECT * FROM food WHERE type = 'drink'";
        return jdbcTemplate.query(sql, new FoodMapper());
    }

    @Override
    public List<Food> findSnacks() {
        String sql = "SELECT * FROM food WHERE type = 'snack'";
        return jdbcTemplate.query(sql, new FoodMapper());
    }

    @Override
    public Food findById(int id) {
        String sql = "SELECT * FROM food WHERE id=?";
        return (Food) jdbcTemplate.queryForObject(sql, new FoodMapper(), id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM food WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void create(Food food) {
        String sql ="INSERT INTO food VALUES (DEFAULT,?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, food.getName(), food.getDescription(), food.getPrice(),
                food.getWeight(), food.getType(), food.getImage());
    }

    @Override
    public void update(Food food) {
        String sql = "UPDATE food SET name=?, description=?, price=?, weight=?, type=? WHERE id = ?";
        jdbcTemplate.update(sql,food.getName(), food.getDescription(), food.getPrice(), food.getWeight(),
                food.getType(), food.getId());
    }
}
