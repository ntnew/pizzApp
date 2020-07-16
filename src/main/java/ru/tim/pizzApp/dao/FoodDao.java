package ru.tim.pizzApp.dao;

import ru.tim.pizzApp.entity.Food;

import java.util.List;

public interface FoodDao {

    List<Food> findAll();

    List<Food> findPizza();

    List<Food> findDrinks();

    List<Food> findSnacks();

    Food findById(int id);

    void deleteById(int id);

    void create(Food food);

    void update(Food food);

    void insertNewImage(Food food);

}
