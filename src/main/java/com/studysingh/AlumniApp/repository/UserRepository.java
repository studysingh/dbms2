package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFname(rs.getString("fname"));
            user.setLname(rs.getString("lname"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
            user.setEmail(rs.getString("email"));  // Mapping the new 'email' column
            return user;
        }
    };

    // Retrieve all users
    public List<User> findAll() {
        String sql = "SELECT * FROM Users";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    // Retrieve a user by their ID
    public User findById(int userId) {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, userRowMapper, userId);
    }

    // Save a new user
    public User save(User user) {
        String sql = "INSERT INTO Users (fname, lname, password, role, email) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, user.getFname(), user.getLname(), user.getPassword(), user.getRole(), user.getEmail());
        // getting userId
        sql = "select user_id from Users where email = ?";
        try {
            // Retrieve only the first college_id, even if there are duplicates
            List<Integer> userId = jdbcTemplate.queryForList(sql, Integer.class, user.getEmail());

            // Return the first result if any, otherwise return -1
            user.setUserId(userId.get(0));
            return user;

        } catch (Error e) {
            // Handle the case where no college_id is found
            return null;
        }
    }

    // Update an existing user's details
    public int update(User user) {
        String sql = "UPDATE Users SET fname = ?, lname = ?, password = ?, role = ?, email = ? WHERE user_id = ?";
        return jdbcTemplate.update(sql, user.getFname(), user.getLname(), user.getPassword(), user.getRole(), user.getEmail(), user.getUserId());
    }

    // Delete a user by their ID
    public int deleteById(int userId) {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId);
    }

    public int getUserByEmail(User user) {
            String sql = "SELECT user_id FROM Users WHERE email = ?";

            try {
                // Retrieve only the first college_id, even if there are duplicates
                List<Integer> userIds = jdbcTemplate.queryForList(sql, Integer.class, user.getEmail());

                // Return the first result if any, otherwise return 0
                if(userIds.isEmpty()){
                    save(user);
                    userIds = jdbcTemplate.queryForList(sql, Integer.class, user.getEmail());
                }
                return  userIds.get(0);
            } catch (Error e) {
                // Handle the case where no college_id is found
                return -1;
            }
    }

    public int verifyUser(User user) {
        String sql = "SELECT user_id FROM Users WHERE email = ? AND password = ? AND role = ?";

        try {
            // Query the database with the provided email, password, and role
            List<Integer> result = jdbcTemplate.queryForList(sql, Integer.class,
                    user.getEmail(), user.getPassword(), user.getRole());

            // If no user is found, return -1
            if (result.isEmpty()) {
                return 0;
            }

            // If a match is found, return the user_id (or any other field you want)
            return result.get(0);

        } catch (Exception e) {
            // Handle the exception (optional: log it)
            return -1;  // Return -1 in case of error
        }
    }

}
