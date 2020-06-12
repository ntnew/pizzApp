package ru.tim.pizzApp.service;

import ru.tim.pizzApp.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> findAll();

    List<Food> findPizza();

    List<Food> findDrinks();

    List<Food> findSnacks();
}
