package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Games;
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
public class GamesDaoTest {

    @Autowired
    GamesDao dao;

    @Before
    public void setUp() throws Exception {
        List<Games> gamesList = dao.getAllGames();
        gamesList.stream()
                .forEach(game->{
                    dao.deleteGames(game.getId());
                });
    }

    @After
    public void tearDown() throws Exception {
        List<Games> gamesList = dao.getAllGames();
        gamesList.stream()
                .forEach(game->{
                    dao.deleteGames(game.getId());
                });
    }

    @Test
    public void addGetDeleteGames() {
        Games game = new Games();
        game.setTitle("shinobi");
        game.setDescription("war game");
        game.setErsbRating("3");
        game.setStudio("studiom");
        game.setPrice(new BigDecimal(12.45).setScale(2,HALF_UP));
        game.setQuantity(23);
        game = dao.addGames(game);

        Games game1 = dao.getGames(game.getId());

        assertEquals(game1, game);

        dao.deleteGames(game.getId());
        game1 = dao.getGames(game.getId());

        assertNull(game1);
    }

    @Test
    public void getAllGames() {
        Games game = new Games();
        game.setTitle("shinobi");
        game.setDescription("war game");
        game.setErsbRating("3");
        game.setStudio("studiom");
        game.setPrice(new BigDecimal(12.45).setScale(2,HALF_UP));
        game.setQuantity(23);

        game = dao.addGames(game);

        List<Games> gamesList = dao.getAllGames();
        assertEquals(gamesList.size(),1);
    }

    @Test
    public void updateGames() {
        Games game = new Games();
        game.setTitle("shinobi");
        game.setDescription("war game");
        game.setErsbRating("3");
        game.setStudio("studiom");
        game.setPrice(new BigDecimal(12.45).setScale(2, HALF_UP));
        game.setQuantity(23);
        game = dao.addGames(game);

        game.setTitle("mtitle");
        game.setDescription("new game");
        dao.updateGames(game);

        Games game2 = dao.getGames(game.getId());

        assertEquals(game2,game);

    }

    @Test
    public void getGamesByStudio() {

        Games game = new Games();
        game.setTitle("shinobi");
        game.setDescription("war game");
        game.setErsbRating("3");
        game.setStudio("studiom");
        game.setPrice(new BigDecimal(12.45).setScale(2,HALF_UP));
        game.setQuantity(23);

        game = dao.addGames(game);

        game = new Games();
        game.setTitle("shinobi");
        game.setErsbRating("5");
        game.setDescription("ninja game");
        game.setPrice(new BigDecimal(2.2).setScale(2,HALF_UP));
        game.setStudio("studiom");
        game.setQuantity(11);

        dao.addGames(game);

        game = new Games();
        game.setTitle("vendetta");
        game.setErsbRating("5");
        game.setDescription("fight game");
        game.setPrice(new BigDecimal(5.2).setScale(2,HALF_UP));
        game.setStudio("studio2");
        game.setQuantity(13);

        dao.addGames(game);

        List<Games> gamesList = dao.getGamesByStudio("studiom");
        assertEquals(gamesList.size(),2);

        gamesList = dao.getGamesByStudio("studio2");
        assertEquals(gamesList.size(),1);

        gamesList = dao.getGamesByStudio("studio1");
        assertEquals(gamesList.size(),0);



    }

    @Test
    public void getGameByEsrb() {

        Games game = new Games();
        game.setTitle("shinobi");
        game.setDescription("war game");
        game.setErsbRating("3");
        game.setStudio("studiom");
        game.setPrice(new BigDecimal(12.45).setScale(2,HALF_UP));
        game.setQuantity(23);

        game = dao.addGames(game);

        game = new Games();
        game.setTitle("shinobi");
        game.setErsbRating("5");
        game.setDescription("ninja game");
        game.setPrice(new BigDecimal(2.2).setScale(2,HALF_UP));
        game.setStudio("studiom");
        game.setQuantity(11);

        dao.addGames(game);

        game = new Games();
        game.setTitle("vendetta");
        game.setErsbRating("5");
        game.setDescription("fight game");
        game.setPrice(new BigDecimal(5.2).setScale(2,HALF_UP));
        game.setStudio("studio2");
        game.setQuantity(13);

        dao.addGames(game);

        List<Games> gamesList = dao.getGamesByErsb("5");
        assertEquals(gamesList.size(),2);

        gamesList = dao.getGamesByErsb("3");
        assertEquals(gamesList.size(),1);

        gamesList = dao.getGamesByErsb("1");
        assertEquals(gamesList.size(),0);
    }

    @Test
    public void getGamesByTitle() {
        Games game = new Games();
        game.setTitle("shinobi");
        game.setDescription("war game");
        game.setErsbRating("3");
        game.setStudio("studiom");
        game.setPrice(new BigDecimal(12.45).setScale(2,HALF_UP));
        game.setQuantity(23);

        game = dao.addGames(game);

        game = new Games();
        game.setTitle("shinobi");
        game.setErsbRating("5");
        game.setDescription("ninja game");
        game.setPrice(new BigDecimal(2.2).setScale(2,HALF_UP));
        game.setStudio("studiom");
        game.setQuantity(11);

        dao.addGames(game);

        game = new Games();
        game.setTitle("vendetta");
        game.setErsbRating("5");
        game.setDescription("fight game");
        game.setPrice(new BigDecimal(5.2).setScale(2,HALF_UP));
        game.setStudio("studio2");
        game.setQuantity(13);

        dao.addGames(game);

        List<Games> gamesList = dao.getGamesByTitle("shinobi");
        assertEquals(gamesList.size(),2);

        gamesList = dao.getGamesByTitle("vendetta");
        assertEquals(gamesList.size(),1);

        gamesList = dao.getGamesByTitle("street fighter");
        assertEquals(gamesList.size(),0);
    }
}