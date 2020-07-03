package ru.tim.pizzApp.dao;


import ru.tim.pizzApp.entity.Bucket;

import java.util.List;

public interface BucketDao {

    void save(Bucket bucket);

    List<Bucket> findByLogin(String userLogin);

    void deleteById(int id);

    void deleteByLogin(String userLogin);
}
