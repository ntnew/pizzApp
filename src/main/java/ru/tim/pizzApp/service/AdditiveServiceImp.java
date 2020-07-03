package ru.tim.pizzApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tim.pizzApp.dao.AdditiveDao;
import ru.tim.pizzApp.dao.FoodDao;
import ru.tim.pizzApp.entity.Additive;

import java.util.List;

@Service
public class AdditiveServiceImp implements AdditiveService {

    @Autowired
    public AdditiveDao additiveDao;
    @Override
    public List<Additive> findAll() {
        return additiveDao.findAll();
    }

    @Override
    public Double findPriceByName(String additiveName) {
        return additiveDao.findPriceByName(additiveName);
    }
}
