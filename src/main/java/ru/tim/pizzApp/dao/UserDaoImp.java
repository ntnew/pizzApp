package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql ="INSERT INTO users (user_id, name, role, email, phone, address, password) VALUES (DEFAULT,?, DEFAULT, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getPassword());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE user_id=:?";
        return (User) jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public User getByUsername(String username) {
        String sql = "SELECT * FROM users WHERE name=?";
        User user;
        try {
            user = (User) jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }

    @Override
    public String getRoleByLogin(String username) {
        return null;
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
