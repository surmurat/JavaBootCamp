package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.ProcessingFee;
import com.example.MuratSurenlerU1Capstone.Model.SalesTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxDaoJdbcTemplateImpl implements SalesTaxDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SELECT_ALL_SALES_TAXES_RATES_SQL =
            "select * from sales_tax_rate";

    private static final String SELECT_SALES_TAX_RATES_BY_STATES_SQL =
            "select * from sales_tax_rate where state = ?";


    @Override
    public List<SalesTax> getAllSalesTaxRates() {
        return jdbcTemplate.query(SELECT_ALL_SALES_TAXES_RATES_SQL,this::mapRowToSalesTax);
    }

    @Override
    public SalesTax getSalesTaxRateByState(String state) {
        try {

            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATES_BY_STATES_SQL,this::mapRowToSalesTax, state);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }



    private SalesTax mapRowToSalesTax(ResultSet rs, int rowNum) throws SQLException {
        SalesTax salesTax = new SalesTax();
        salesTax.setState(rs.getString("state"));
        salesTax.setRate(rs.getBigDecimal("rate"));

        return salesTax;
    }
}

