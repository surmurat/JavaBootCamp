package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Consoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ConsolesDaoJdbcTemplateImpl implements ConsolesDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_CONSOLES_SQL =

            "insert into console(model,manufacturer,memory_amount,processor,price,quantity) values(?,?,?,?,?,?)";

    private static final String UPDATE_CONSOLES_SQL =
            "update console set model=?, manufacturer=?, memory_amount=?, processor=?, price=?, quantity=? where game_id=?";

    private static final String SELECT_CONSOLES_SQL =
            "select * from console where game_id = ?";

    private static final String SELECT_ALL_CONSOLES_SQL =
            "select * from console";

    private static final String DELETE_CONSOLES_SQL =
            " delete from console where game_id =?";

    private static final String SELECT_CONSOLES_BY_MANUFACTURER =
            "select * from console where manufacturer = ? ";

    @Autowired
    public ConsolesDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Consoles getConsoles(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_CONSOLES_SQL, this::mapRowToConsoles, id);

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateConsoles(Consoles consoles) {

        jdbcTemplate.update(
                UPDATE_CONSOLES_SQL,
                consoles.getModel(),
                consoles.getManufacturer(),
                consoles.getMemoryAmount(),
                consoles.getProcessor(),
                consoles.getPrice(),
                consoles.getQuantity(),
                consoles.getGameId());
    }


    @Override
    public Consoles addConsoles(Consoles consoles) {
        jdbcTemplate.update(
                INSERT_CONSOLES_SQL,
                consoles.getModel(),
                consoles.getManufacturer(),
                consoles.getMemoryAmount(),
                consoles.getProcessor(),
                consoles.getPrice(),
                consoles.getQuantity());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        consoles.setGameId(id);

        return consoles;
    }

    @Override
    public List<Consoles> getAllConsoles() {

        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsoles);
    }

    @Override
    public void deleteConsoles(int id) {
        jdbcTemplate.update(DELETE_CONSOLES_SQL, id);
    }

    @Override
    public List<Consoles> getConsolesByManufacturer(String manufacturer) {

        return jdbcTemplate.query(SELECT_CONSOLES_BY_MANUFACTURER, this::mapRowToConsoles, manufacturer);
    }

    private Consoles mapRowToConsoles(ResultSet rs, int rowNum) throws SQLException {
        Consoles consoles = new Consoles();

        consoles.setGameId(rs.getInt("game_id"));
        consoles.setModel(rs.getString("model"));
        consoles.setManufacturer(rs.getString("manufacturer"));
        consoles.setMemoryAmount(rs.getString("memory_amount"));
        consoles.setProcessor(rs.getString("processor"));
        consoles.setPrice(rs.getBigDecimal("price"));
        consoles.setQuantity(rs.getInt("quantity"));

        return consoles;
    }


}
