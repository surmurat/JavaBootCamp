package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Consoles;
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
public class ConsolesDaoTest {

    @Autowired
    ConsolesDao dao;



    @Before
    public void setUp() throws Exception {
        List<Consoles> consolesList = dao.getAllConsoles();

        for(Consoles console : consolesList) {
            dao.deleteConsoles(console.getGameId());
        }
            /*consolesList.stream()
                    .forEach(consoles -> {
                        dao.deleteConsoles(consoles.getGameId());
                    });*/
    }

    @After
    public void tearDown() throws Exception {
        List<Consoles> consolesList = dao.getAllConsoles();
        consolesList.stream()
                .forEach(consoles -> {
                    dao.deleteConsoles(consoles.getGameId());
                });
    }

    @Test
    public void addGetDeleteConsoles() {

        Consoles consoles = new Consoles();
        consoles.setGameId(9);
        consoles.setModel("new model");
        consoles.setManufacturer("sony");
        consoles.setMemoryAmount("four");
        consoles.setProcessor("quad");
        consoles.setPrice(new BigDecimal(4.99).setScale(2,HALF_UP));
        consoles.setQuantity(4);
        consoles = dao.addConsoles(consoles);

        Consoles consoles1 = dao.getConsoles(consoles.getGameId());

        assertEquals(consoles1,consoles);

        dao.deleteConsoles(consoles.getGameId());

        consoles1 = dao.getConsoles(consoles.getGameId());

        assertNull(consoles1);

    }



    @Test
    public void getAllConsoles() {
        Consoles consoles = new Consoles();

        consoles.setModel("new model");
        consoles.setManufacturer("sony");
        consoles.setMemoryAmount("four");
        consoles.setProcessor("quad");
        consoles.setPrice(new BigDecimal(4.99));
        consoles.setQuantity(4);

        consoles = dao.addConsoles(consoles);

        List<Consoles> consolesList= dao.getAllConsoles();
        assertEquals(consolesList.size(),1);



    }

    @Test
    public void updateConsoles() {
        Consoles consoles = new Consoles();
        consoles.setModel("new model");
        consoles.setManufacturer("sony");
        consoles.setMemoryAmount("four");
        consoles.setProcessor("quad");
        consoles.setPrice(new BigDecimal(4.99).setScale(2, HALF_UP));
        consoles.setQuantity(4);
        consoles = dao.addConsoles(consoles);

        consoles.setModel("m4");
        consoles.setManufacturer("apple");
        dao.updateConsoles(consoles);

        Consoles consoles2 = dao.getConsoles(consoles.getGameId());

        assertEquals(consoles2,consoles);


    }



    @Test
    public void getConsolesByManufacturer() {

        Consoles consoles = new Consoles();

        consoles.setModel("play station3");
        consoles.setManufacturer("sony");
        consoles.setProcessor("quad4");
        consoles.setMemoryAmount("4");
        consoles.setPrice(new BigDecimal(2.33).setScale(2,HALF_UP));
        consoles.setQuantity(11);

        consoles = dao.addConsoles(consoles);


        List<Consoles> consolesList = dao.getConsolesByManufacturer(consoles.getManufacturer());

        assertEquals(consolesList.size(), 1);
        assertEquals(consolesList.get(0), consoles);



    }
}