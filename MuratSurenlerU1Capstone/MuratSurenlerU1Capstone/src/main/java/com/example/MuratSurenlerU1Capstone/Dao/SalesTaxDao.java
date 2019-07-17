package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.SalesTax;

import java.util.List;

public interface SalesTaxDao{

    List<SalesTax> getAllSalesTaxRates();
    SalesTax getSalesTaxRateByState(String state);

}
