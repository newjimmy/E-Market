package com.market.repository;

import com.market.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CategoriesRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final static String QUERY_FETCH_CATEGORIES = "select category_id, body_type, colour, engine_capacity, engine_volume, max_speed from categories";

    public List<Category> getAllCategories() {
        return jdbcTemplate.query(QUERY_FETCH_CATEGORIES, (resultSet, i) -> {
            return new Category(
                    resultSet.getInt("category_id"),
                    resultSet.getString("body_type"),
                    resultSet.getString("colour"),
                    resultSet.getInt("engine_capacity"),
                    resultSet.getInt("engine_volume"),
                    resultSet.getInt("max_speed")
            );
        });
    }
}