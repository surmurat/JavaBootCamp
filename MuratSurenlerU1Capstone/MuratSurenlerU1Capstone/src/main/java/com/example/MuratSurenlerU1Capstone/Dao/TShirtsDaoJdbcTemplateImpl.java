package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.TShirts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtsDaoJdbcTemplateImpl implements TShirtsDao {

    private JdbcTemplate jdbcTemplate;


    private static final String INSERT_TSHIRTS_SQL =
            "insert into t_shirt (size, color, description, price, quantity) values (?, ?, ?, ?, ?)";

    private static final String SELECT_TSHIRTS_SQL =
            "select * from t_shirt where t_shirt_id = ?";

    private static final String SELECT_ALL_TSHIRTS_SQL =
            "select * from t_shirt";

    private static final String UPDATE_TSHIRTS_SQL =
            "update t_shirt set size = ?, color = ?, description = ?, price = ?, quantity = ? where t_shirt_id = ?";

    private static final String DELETE_TSHIRTS_SQL =
            "delete from t_shirt where t_shirt_id = ?";

    private static final String SELECT_TSHIRTS_BY_SIZE =
            "select * from t_shirt where size = ?";

    private static final String SELECT_TSHIRTS_BY_COLOR =
            "select * from t_shirt where color = ?";


    @Autowired
    public TShirtsDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public TShirts addTShirts(TShirts tShirts) {

        jdbcTemplate.update(
                INSERT_TSHIRTS_SQL,
                tShirts.getSize(),
                tShirts.getColor(),
                tShirts.getDescription(),
                tShirts.getPrice(),
                tShirts.getQuantity());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        tShirts.setId(id);

        return tShirts;
    }


    @Override
    public TShirts getTShirts(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_TSHIRTS_SQL, this::mapRowToTShirts, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    @Override
    public List<TShirts> getAllTShirts() {

        return jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL, this::mapRowToTShirts);
    }

    @Override
    public void updateTShirts(TShirts tShirts) {

        jdbcTemplate.update(
                UPDATE_TSHIRTS_SQL,
                tShirts.getSize(),
                tShirts.getColor(),
                tShirts.getDescription(),
                tShirts.getPrice(),
                tShirts.getQuantity(),
                tShirts.getId());
    }

    @Override
    public void deleteTShirts(int id) {

        jdbcTemplate.update(DELETE_TSHIRTS_SQL, id);
    }

    @Override
    public List<TShirts> getTShirtsBySize(String size){
        return jdbcTemplate.query(SELECT_TSHIRTS_BY_SIZE,this::mapRowToTShirts,size);
    }

    @Override
    public List<TShirts> getTShirtsByColor(String color){
        return jdbcTemplate.query(SELECT_TSHIRTS_BY_COLOR,this::mapRowToTShirts,color);
    }

    private TShirts mapRowToTShirts(ResultSet rs, int rowNum) throws SQLException {
        TShirts tShirts = new TShirts();
        tShirts.setId(rs.getInt("t_shirt_id"));
        tShirts.setSize(rs.getString("size"));
        tShirts.setColor(rs.getString("color"));
        tShirts.setDescription(rs.getString("description"));
        tShirts.setPrice(rs.getBigDecimal("price"));
        tShirts.setQuantity(rs.getInt("quantity"));

        return tShirts;
    }

    }








