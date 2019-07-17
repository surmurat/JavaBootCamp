package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.SalesTax;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import java.util.List;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxTest {

    @Autowired
    SalesTaxDao dao;



    @Test
    public void getAllSalesTaxRates() {

        List<SalesTax> salesTaxList = dao.getAllSalesTaxRates();
        assertEquals(salesTaxList.size(),50);


    }

    @Test
    public void getSalesTaxRateByState() {

        SalesTax salesTax = dao.getSalesTaxRateByState(convertState("NY"));
        BigDecimal bigDecimal = new BigDecimal("0.06").setScale(2);

        assertEquals(salesTax.getRate(), bigDecimal);

    }

    private String convertState(String state){

        switch (state){
            case "Alabama":
            case "AL":
                return "AL";
            case "alaska":
            case "AK":
                return "AK";
            case "Arizona":
            case "AZ":
                return "AZ";
            case "Arkansas":
            case "AR":
                return "AR";
            case "California":
            case "CA":
                return "CA";
            case "Colorado":
            case "CO":
                return "CO";
            case "Connecticut":
            case "CT":
                return "CT";
            case "Delaware":
            case "DE":
                return "DE";
            case "Florida":
            case "FL":
                return "FL";
            case "Georgia":
            case "GA":
                return "GA";
            case "Hawaii":
            case "HI":
                return "HI";
            case "Idaho":
            case "ID":
                return "ID";
            case "Illinois":
            case "IL":
                return "IL";
            case "Indiana":
            case "IN":
                return "IN";
            case "Iowa":
            case "IA":
                return "IA";
            case "Kansas":
            case "KS":
                return "KS";
            case "Kentucky":
            case "KY":
                return "KY";
            case "Louisiana":
            case "LA":
                return "LA";
            case "Maine":
            case "ME":
                return "ME";
            case "Maryland":
            case "MD":
                return "MD";
            case "Massachusetts":
            case "MA":
                return "MA";
            case "Michigan":
            case "MI":
                return "MI";
            case "Minnesota":
            case "MN":
                return "MN";
            case "Mississippi":
            case "MS":
                return "MS";
            case "Missouri":
            case "MO":
                return "MO";
            case "Montana":
            case "MT":
                return "MT";
            case "Nebraska":
            case "NE":
                return "NE";
            case "Nevada":
            case "NV":
                return "NV";
            case "New Hampshire":
            case "NH":
                return "NH";
            case "New Jersey":
            case "NJ":
                return "NJ";
            case "New Mexico":
            case "NM":
                return "NM";
            case "New York":
            case "NY":
                return "NY";
            case "North Carolina":
            case "NC":
                return "NC";
            case "North Dakota":
            case "ND":
                return "ND";
            case "Ohio":
            case "OH":
                return "OH";
            case "Oklahoma":
            case "OK":
                return "OK";
            case "Oregon":
            case "OR":
                return "OR";
            case "Pennsylvania":
            case "PA":
                return "PA";
            case "Rhode Island":
            case "RI":
                return "RI";
            case "South Carolina":
            case "SC":
                return "SC";
            case "South Dakota":
            case "SD":
                return "SD";
            case "Tennessee":
            case "TN":
                return "TN";
            case "Texas":
            case "TX":
                return "TX";
            case "Utah":
            case "UT":
                return "UT";
            case "Vermont":
            case "VT":
                return "VT";
            case "Virginia":
            case "VA":
                return "VA";
            case "Washington":
            case "WA":
                return "WA";
            case "West Virginia":
            case "WV":
                return "WV";
            case "Wisconsin":
            case "WI":
                return "WI";
            case "Wyoming":
            case "WY":
                return "WY";
            default:
                System.out.println("State does not exist");
                break;

        }
        return state;
    }
}