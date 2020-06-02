package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.mapper.UserMapper;

import java.util.List;
@Repository
public class UserDaoImp implements UserDao {

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String sql ="INSERT INTO users ( name, email, phone, address) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getAddress());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE user_id=:?";
        return (User) jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE user_id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name=?, email=?, phone=?, address=? WHERE user_id=:?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getUser_id());

    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
