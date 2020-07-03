package ru.tim.pizzApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tim.pizzApp.entity.Bucket;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.mapper.BucketMapper;
import ru.tim.pizzApp.mapper.UserMapper;

import java.util.List;
@Repository
public class BucketDaoImp implements BucketDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void save(Bucket bucket) {
        String sql ="INSERT INTO bucket VALUES (DEFAULT, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, bucket.getUser_login(), bucket.getOrder(), bucket.getAdditives(), bucket.getPrice());
    }

    @Override
    public List<Bucket> findByLogin(String userLogin) {
        String sql = "SELECT * FROM bucket WHERE userLogin LIKE ?";
        return jdbcTemplate.query(sql, new BucketMapper(), userLogin);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM bucket WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
    @Override
    public void deleteByLogin(String userLogin) {
        String sql = "DELETE FROM bucket WHERE userLogin LIKE ?";
        jdbcTemplate.update(sql, userLogin);
    }
}
