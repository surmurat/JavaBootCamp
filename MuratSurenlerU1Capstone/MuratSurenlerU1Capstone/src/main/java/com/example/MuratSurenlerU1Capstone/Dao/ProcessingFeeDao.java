package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {
    List<ProcessingFee> getAllProcessingFee();

    ProcessingFee getProcessingFeeByProducts(String product);


}
