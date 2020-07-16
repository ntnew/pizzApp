package ru.tim.pizzApp.service;

import ru.tim.pizzApp.entity.Additive;

import java.util.List;

public interface AdditiveService {
    List<Additive> findAll();

    Double findPriceByName(String additiveName);

}
