package ru.tim.pizzApp.service;

import ru.tim.pizzApp.entity.Bucket;

import java.util.List;

public interface BucketService {
    void save(Bucket bucket);

    List<Bucket> findByLogin(String userLogin);

    void deleteById(int id);

    void deleteByLogin(String userLogin);
}
