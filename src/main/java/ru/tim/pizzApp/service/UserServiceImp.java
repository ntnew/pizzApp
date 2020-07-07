package ru.tim.pizzApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tim.pizzApp.dao.UserDao;
import ru.tim.pizzApp.entity.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserDao userDao;


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User getById(int id) {
        return (User) userDao.getById(id);
    }

    @Override
    public User getByUserName(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public void delete(String login) {
        userDao.delete(login);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }

    @Override
    public void makeAdminByLogin(String login) {
        userDao.makeAdminByLogin(login);
    }

    @Override
    public void bustAdminByLogin(String login) {
        userDao.bustAdminByLogin(login);
    }
}
