package ru.tim.pizzApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tim.pizzApp.dao.BucketDao;
import ru.tim.pizzApp.entity.Bucket;

import java.util.List;
@Service
public class BucketServiceImp implements BucketService {

    @Autowired
    public BucketDao bucketDao;
    @Override
    public void save(Bucket bucket) {
        bucketDao.save(bucket);
    }

    @Override
    public List<Bucket> findByLogin(String userLogin) {
        return bucketDao.findByLogin(userLogin);
    }

    @Override
    public void deleteById(int id) {
        bucketDao.deleteById(id);
    }

    @Override
    public void deleteByLogin(String userLogin) {
        bucketDao.deleteByLogin(userLogin);
    }
}
