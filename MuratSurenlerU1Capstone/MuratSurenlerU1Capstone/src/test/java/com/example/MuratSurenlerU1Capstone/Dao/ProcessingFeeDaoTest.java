package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.ProcessingFee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    ProcessingFeeDao dao;



    @Test
    public void getAllProcessingFee() {

        List<ProcessingFee> processingFeeList = dao.getAllProcessingFee();
        assertEquals(processingFeeList.size(),3);

    }
    @Test
    public void getProcessingFeeByProducts() {
        ProcessingFee processingFee = dao.getProcessingFeeByProducts("consoles");
        BigDecimal bigDecimal = new BigDecimal("14.99").setScale(2);
        assertEquals(processingFee.getFee(),bigDecimal);

    }
}