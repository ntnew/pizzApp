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
        String sql ="INSERT INTO users (user_id, login, password, name, role, email, phone, address) VALUES (DEFAULT,?, ?, ?, DEFAULT, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getLogin(), user.getPassword(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress());
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
    public void delete(String login) {
        String sql = "DELETE FROM users WHERE login=?";
        jdbcTemplate.update(sql,login);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name=?, email=?, phone=?, address=? WHERE login = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getLogin());

    }

    @Override
    public void updatePassword(User user) {
        String sql = "UPDATE users SET password=? WHERE login = ?";
        jdbcTemplate.update(sql, user.getPassword(), user.getLogin());
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User getByLogin(String login) {
        String sql = "SELECT * FROM users WHERE login=?";
        User user;
        try {
            user = (User) jdbcTemplate.queryForObject(sql, new UserMapper(), login);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }

    @Override
    public void makeAdminByLogin(String login) {
        String sql = "UPDATE users SET role=? WHERE login = ?";
        jdbcTemplate.update(sql, "ROLE_ADMIN",login);
    }

    @Override
    public void bustAdminByLogin(String login) {
        String sql = "UPDATE users SET role=? WHERE login = ?";
        jdbcTemplate.update(sql, "ROLE_USER",login);
    }
}
