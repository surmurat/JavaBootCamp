package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.TShirts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtsDaoTest {

    @Autowired
    TShirtsDao dao;

    @Before
    public void setUp() throws Exception {
        List<TShirts> tShirtsList = dao.getAllTShirts();
            tShirtsList.stream()
                    .forEach(tShirts -> {
                        dao.deleteTShirts(tShirts.getId());
                    });
    }

    @After
    public void tearDown() throws Exception {
        List<TShirts> tShirtsList = dao.getAllTShirts();
        tShirtsList.stream()
                .forEach(tShirts -> {
                    dao.deleteTShirts(tShirts.getId());
                });
    }

    @Test
    public void addGetDeleteTShirts() {
        TShirts tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("short sleeve");
        tShirts.setPrice(new BigDecimal(3.88).setScale(2,HALF_UP));
        tShirts.setQuantity(11);
        tShirts= dao.addTShirts(tShirts);

        TShirts tShirts1 = dao.getTShirts(tShirts.getId());
        assertEquals(tShirts1,tShirts);

        dao.deleteTShirts(tShirts.getId());
        tShirts1 = dao.getTShirts(tShirts.getId());

        assertNull(tShirts1);

    }


    @Test
    public void getAllTShirts() {
        TShirts tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("short sleeve");
        tShirts.setPrice(new BigDecimal(3.88).setScale(2,HALF_UP));
        tShirts.setQuantity(11);
        tShirts= dao.addTShirts(tShirts);

        List<TShirts> tShirtsList = dao.getAllTShirts();
        assertEquals(tShirtsList.size(),1);
    }

    @Test
    public void updateTShirts() {
        TShirts tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("short sleeve");
        tShirts.setPrice(new BigDecimal(3.88).setScale(2,HALF_UP));
        tShirts.setQuantity(11);
        tShirts= dao.addTShirts(tShirts);

        tShirts.setSize("small");
        tShirts.setDescription("long sleeve");
        dao.updateTShirts(tShirts);

        TShirts tShirts2 = dao.getTShirts(tShirts.getId());

        assertEquals(tShirts2,tShirts);
    }


    @Test
    public void getTShirtsByColor() {
        TShirts tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("short sleeve");
        tShirts.setPrice(new BigDecimal(3.88).setScale(2,HALF_UP));
        tShirts.setQuantity(11);

         dao.addTShirts(tShirts);

        tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("blue collar");
        tShirts.setPrice(new BigDecimal(6.88).setScale(2,HALF_UP));
        tShirts.setQuantity(17);

         dao.addTShirts(tShirts);

        tShirts = new TShirts();
        tShirts.setSize("small");
        tShirts.setColor("red");
        tShirts.setDescription("white collar");
        tShirts.setPrice(new BigDecimal(7.88).setScale(2,HALF_UP));
        tShirts.setQuantity(87);

         dao.addTShirts(tShirts);

        List<TShirts> tShirtsList = dao.getTShirtsByColor("blue");
        assertEquals(tShirtsList.size(),2);

        tShirtsList = dao.getTShirtsByColor("red");
        assertEquals(tShirtsList.size(),1);

        tShirtsList = dao.getTShirtsByColor("black");
        assertEquals(tShirtsList.size(),0);
    }

    @Test
    public void getTShirtsBySize() {

        TShirts tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("short sleeve");
        tShirts.setPrice(new BigDecimal(3.88).setScale(2,HALF_UP));
        tShirts.setQuantity(11);

         dao.addTShirts(tShirts);

        tShirts = new TShirts();
        tShirts.setSize("medium");
        tShirts.setColor("blue");
        tShirts.setDescription("blue collar");
        tShirts.setPrice(new BigDecimal(6.88).setScale(2,HALF_UP));
        tShirts.setQuantity(17);

        dao.addTShirts(tShirts);

        tShirts = new TShirts();
        tShirts.setSize("small");
        tShirts.setColor("red");
        tShirts.setDescription("white collar");
        tShirts.setPrice(new BigDecimal(7.88).setScale(2,HALF_UP));
        tShirts.setQuantity(87);

        dao.addTShirts(tShirts);

        List<TShirts> tShirtsList = dao.getTShirtsBySize("medium");
        assertEquals(tShirtsList.size(),2);

        tShirtsList = dao.getTShirtsBySize("small");
        assertEquals(tShirtsList.size(),1);

        tShirtsList = dao.getTShirtsBySize("large");
        assertEquals(tShirtsList.size(),0);
    }
}