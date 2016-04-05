package com.market.repository;

import com.market.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductsRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final static String QUERY_FETCH_PRODUCTS = "select id, model, year, mileage, price from car";

    public List<Product> getFetchProducts() {
        return jdbcTemplate.query(QUERY_FETCH_PRODUCTS, (resultSet, i) -> {
            return new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getInt("year"),
                    resultSet.getInt("mileage"),
                    resultSet.getInt("price")
            );
        });
    }
}