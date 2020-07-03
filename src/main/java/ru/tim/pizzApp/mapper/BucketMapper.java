package ru.tim.pizzApp.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tim.pizzApp.entity.Bucket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BucketMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Bucket bucket = new Bucket();
        bucket.setId(resultSet.getInt("id"));
        bucket.setUser_login(resultSet.getString("userLogin"));
        bucket.setOrder(resultSet.getString("order"));
        bucket.setAdditives(resultSet.getString("additives"));
        bucket.setPrice(resultSet.getDouble("price"));
        return bucket;
    }
}
