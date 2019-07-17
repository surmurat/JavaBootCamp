package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Games;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GamesDaoJdbcTemplateImpl implements GamesDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_GAMES_SQL =

            "insert into game(title,ersb_rating,description ,price,studio,quantity  ) values(?,?,?,?,?,?)";

    private static final String UPDATE_GAMES_SQL =
            "update game set title=?, ersb_rating=?, description=?, price=?, studio=?, quantity=? where game_id=?";

    private static final String SELECT_GAMES_SQL =
            "select * from game where game_id = ?";

    private static final String SELECT_ALL_GAMES_SQL =
            "select * from game";

    private static final String DELETE_GAMES_SQL =
            " delete from game where game_id =?";

    private static final String SELECT_GAMES_BY_STUDIO =
            "select * from game where studio =? ";

    private static final String SELECT_GAMES_BY_ERSB_RATING =
            "select * from game where ersb_rating =? ";

    private static final String SELECT_GAMES_BY_TITLE =
            "select * from game where title =? ";

    @Autowired
    public GamesDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Games addGames(Games games) {
        jdbcTemplate.update(INSERT_GAMES_SQL,
                games.getTitle(),
                games.getErsbRating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity()
                );

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        games.setId(id);

        return games;
    }

    @Override
    public Games getGames(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_GAMES_SQL, this::mapRowToGames, id);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Games> getAllGames() {

        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL,this::mapRowToGames);
    }

    @Override
    public void updateGames(Games games){
//"update game set title=?, ersb_rating=?, description=?, price=?, studio=?, quantity=? where game_id=?";
        jdbcTemplate.update(
                UPDATE_GAMES_SQL,
                games.getTitle(),
                games.getErsbRating(),
                games.getDescription(),
                games.getPrice(),
                games.getStudio(),
                games.getQuantity(),
                games.getId());
    }

    @Override
    public void deleteGames(int id) {
        jdbcTemplate.update(DELETE_GAMES_SQL, id);

    }

    @Override
    public List<Games> getGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_GAMES_BY_STUDIO,this::mapRowToGames, studio);
    }

    @Override
    public List<Games> getGamesByErsb(String ersb) {

        return jdbcTemplate.query(SELECT_GAMES_BY_ERSB_RATING, this::mapRowToGames,ersb);
    }

    @Override
    public List<Games> getGamesByTitle(String title) {

        return jdbcTemplate.query(SELECT_GAMES_BY_TITLE,this::mapRowToGames,title);
    }


    private Games mapRowToGames(ResultSet rs, int rowNum)throws SQLException{

        Games games = new Games();
        games.setDescription(rs.getString("description"));
        games.setTitle(rs.getString("title"));
        games.setErsbRating(rs.getString("ersb_rating"));
        games.setStudio(rs.getString("studio"));
        games.setPrice(rs.getBigDecimal("price"));
        games.setQuantity(rs.getInt("quantity"));
        games.setId(rs.getInt("game_id"));

        return games;
    }


}
