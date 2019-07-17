package com.example.MuratSurenlerU1Capstone.controller;


import com.example.MuratSurenlerU1Capstone.servicelayer.ServiceLayer;

import com.example.MuratSurenlerU1Capstone.viewmodel.GamesViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GamesController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public List<GamesViewModel> getAllGames() {
        return serviceLayer.findAllGames();
    }

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public GamesViewModel createGames(@RequestBody @Valid GamesViewModel games) {
        return serviceLayer.saveGame(games);
    }

    @GetMapping("/{id}")//Another way to set the Rest API Get mapping
    @ResponseStatus(HttpStatus.OK)
    public GamesViewModel getGames(@PathVariable("id") int gameId) {
        GamesViewModel gamesViewModel = serviceLayer.findGamesbyId(gameId);
        if (gamesViewModel == null)
            throw new IllegalArgumentException("Games could not be retrieved for id " + gameId);
        return gamesViewModel;
    }

    @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGames(@PathVariable("id") int gameId) {
        serviceLayer.removeGame(gameId);
    }

    @PutMapping("/{id}")//Another way to set the Rest API Put mapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGames(@PathVariable("id") int gameId, @RequestBody @Valid GamesViewModel gamesViewModel) {
        if (gamesViewModel.getId() == 0)
            gamesViewModel.setId(gameId);
        if (gameId != gamesViewModel.getId()) {
            throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object");
        }
        serviceLayer.updateGame(gamesViewModel);
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GamesViewModel> getGamesByStudio(@PathVariable("studio") String studio) {
        List<GamesViewModel> games = serviceLayer.findGamesByStudio(studio);
        if (games != null && games.size() == 0)
            throw new IllegalArgumentException("Game could not be retrieved for customer " + studio);
        return games;
    }

    @GetMapping("/ersb/{ersb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GamesViewModel> getGamesByErsb(@PathVariable("ersb") String ersb) {
        List<GamesViewModel> games = serviceLayer.findGamesByErsb(ersb);
        if (games != null && games.size() == 0)
            throw new IllegalArgumentException("Game could not be retrieved for customer " + ersb);
        return games;
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GamesViewModel> getGamesByTitle(@PathVariable("title") String title) {
        List<GamesViewModel> games = serviceLayer.findGamesByTitle(title);
        if (games != null && games.size() == 0)
            throw new IllegalArgumentException("Game could not be retrieved for customer " + title);
        return games;
    }
}
