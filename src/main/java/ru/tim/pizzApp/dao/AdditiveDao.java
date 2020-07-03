package ru.tim.pizzApp.dao;

import ru.tim.pizzApp.entity.Additive;


import java.util.List;

public interface AdditiveDao {

    List<Additive> findAll();

    Double findPriceByName(String additiveName);
}
