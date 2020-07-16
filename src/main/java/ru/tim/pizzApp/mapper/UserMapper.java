package ru.tim.pizzApp.mapper;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import ru.tim.pizzApp.entity.User;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setLogin(resultSet.getString("login"));
        user.setName(resultSet.getString("name"));
        user.setUser_id(resultSet.getInt("user_id"));
        user.setRole(resultSet.getString("role"));
        user.setAddress(resultSet.getString("address"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
