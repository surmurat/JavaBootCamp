package com.example.MuratSurenlerU1Capstone.Dao;

import com.example.MuratSurenlerU1Capstone.Model.Consoles;
import com.example.MuratSurenlerU1Capstone.Model.Games;
import com.example.MuratSurenlerU1Capstone.Model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_PROCESSING_FEE_SQL =
            "select * from processing_fee";

    private static final String SELECT_PROCESSING_FEE_BY_PRODUCTS =
            "select * from processing_fee where product_type = ?";

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProcessingFee> getAllProcessingFee() {

        return jdbcTemplate.query(SELECT_ALL_PROCESSING_FEE_SQL,this::mapRowToProcessingFee);
    }

    @Override
    public ProcessingFee getProcessingFeeByProducts(String product){
        try {

            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_BY_PRODUCTS,this::mapRowToProcessingFee, product);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }



}
