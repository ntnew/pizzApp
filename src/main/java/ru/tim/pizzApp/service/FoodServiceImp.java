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

    @Override
    public void deleteById(int id) {
        foodDao.deleteById(id);
    }

    @Override
    public void create(Food food) {
        foodDao.create(food);
    }

    @Override
    public void update(Food food) {
        foodDao.update(food);
    }

    @Override
    public void insertNewImage(Food food) {
        foodDao.insertNewImage(food);
    }
}
