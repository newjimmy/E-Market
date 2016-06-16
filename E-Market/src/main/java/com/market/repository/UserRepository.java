package com.market.repository;

import com.market.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private final static String QUERY_INSERT_USER_DETAILS = "INSERT INTO new_users (username, email, password ) VALUES (?,?,?)";
    private final static String QUERY_INSERT_ID_TO_USERS_TO_ROLES = "INSERT INTO new_users_to_roles (role_id, user_id) VALUES (?,?)";
    private final static String QUERY_GET_ROLE_ID = "SELECT role_id FROM roles WHERE role_name = ?";

    public int setUserDetails(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(QUERY_INSERT_USER_DETAILS, new String[]{"user_id"});
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, hashedPassword);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void setUserRole(int roleId, int userId) {
        jdbcTemplate.update(QUERY_INSERT_ID_TO_USERS_TO_ROLES, ps -> {
            ps.setInt(1, roleId);
            ps.setInt(2, userId);
        });
    }

    public int getRoleId(String roleName) {
        List<Integer> result = jdbcTemplate.query(QUERY_GET_ROLE_ID, ps -> {
            ps.setString(1, roleName);
        }, (rs, r) -> {
            return rs.getInt(1);
        });
        if (result.isEmpty()) {
            return -1;
        } else {
            return result.get(0);
        }
    }

    public Map<String, Integer> getAllRoles() {
        Map<String, Integer> result = new HashMap<>();
        String sql = "SELECT role_name, role_id FROM roles";
        jdbcTemplate.query(sql, resultSet -> {
            String roleName = resultSet.getString(1);
            int roleId = resultSet.getInt(2);
            result.put(roleName, roleId);
            return null;
        });
        return result;
    }
}
