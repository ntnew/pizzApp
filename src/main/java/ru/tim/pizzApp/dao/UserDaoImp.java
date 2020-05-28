package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.mapper.UserMapper;

import java.util.List;

public class UserDaoImp implements UserDao {

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
