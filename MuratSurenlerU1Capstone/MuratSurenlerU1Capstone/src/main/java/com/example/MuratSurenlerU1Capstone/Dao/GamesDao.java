package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Games;


import java.util.List;

public interface GamesDao {
    Games addGames(Games games);

    Games getGames(int id);

    List<Games> getAllGames();

    void updateGames(Games games);

    void deleteGames(int id);

    List<Games> getGamesByStudio(String studio);

    List<Games> getGamesByErsb(String ersb);

    List<Games> getGamesByTitle(String title);
}
