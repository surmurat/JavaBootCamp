package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.TShirts;

import java.util.List;

public interface TShirtsDao {

    TShirts addTShirts(TShirts tShirts);

    TShirts getTShirts(int id);

    List<TShirts> getAllTShirts();

    void updateTShirts(TShirts tShirts);

    void deleteTShirts(int id);

    List<TShirts> getTShirtsByColor(String color);

    List<TShirts> getTShirtsBySize(String size);
}
