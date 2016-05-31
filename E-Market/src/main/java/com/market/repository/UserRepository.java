package com.market.repository;

import com.market.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final static String QUERY_INSERT_USER_DETAILS = "INSERT INTO users (username, email, password ) VALUES (?,?,?)";

    public void setUserDetails(User user) {
        jdbcTemplate.update(QUERY_INSERT_USER_DETAILS,
                preparedStatement -> {
                    preparedStatement.setString(1, user.getUsername());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, user.getPassword());
                });
    }
}
