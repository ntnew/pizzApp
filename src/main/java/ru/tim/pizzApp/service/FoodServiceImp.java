package ru.tim.pizzApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tim.pizzApp.dao.FoodDao;
import ru.tim.pizzApp.entity.Food;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService{

    @Autowired
    public FoodDao foodDao;
    @Override
    public List<Food> findAll() {
        return foodDao.findAll();
    }

    @Override
    public List<Food> findPizza() { return  foodDao.findPizza(); }

    @Override
    public List<Food> findDrinks() {
        return foodDao.findDrinks();
    }

    @Override
    public List<Food> findSnacks() {
        return foodDao.findSnacks();
    }
}
