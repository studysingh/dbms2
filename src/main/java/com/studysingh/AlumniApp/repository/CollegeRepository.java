package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CollegeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<College> collegeRowMapper = new RowMapper<College>() {
        @Override
        public College mapRow(ResultSet rs, int rowNum) throws SQLException {
            College college = new College();
            college.setCollegeId(rs.getInt("college_id"));
            college.setCollegeName(rs.getString("college_name"));
            return college;
        }
    };

    public List<College> findAll() {
        String sql = "SELECT * FROM Colleges";
        return jdbcTemplate.query(sql, collegeRowMapper);
    }

    public College findById(int collegeId) {
        String sql = "SELECT * FROM Colleges WHERE college_id = ?";
        return jdbcTemplate.queryForObject(sql, collegeRowMapper, collegeId);
    }

    public int save(College college) {
        String sql = "INSERT INTO Colleges (college_name) VALUES (?)";
        return jdbcTemplate.update(sql, college.getCollegeName());
    }

    public int update(College college) {
        String sql = "UPDATE Colleges SET college_name = ? WHERE college_id = ?";
        return jdbcTemplate.update(sql, college.getCollegeName(), college.getCollegeId());
    }

    public int deleteById(int collegeId) {
        String sql = "DELETE FROM Colleges WHERE college_id = ?";
        return jdbcTemplate.update(sql, collegeId);
    }




    public int getCollegeIdByCollegeName(College college) {
        String sql = "SELECT college_id FROM Colleges WHERE college_name = ?";

        try {
            // Retrieve only the first college_id, even if there are duplicates
            List<Integer> collegeIds = jdbcTemplate.queryForList(sql, Integer.class, college.getCollegeName());

            // Return the first result if any, otherwise return 0
            if(collegeIds.isEmpty()){
                save(college);
                collegeIds = jdbcTemplate.queryForList(sql, Integer.class, college.getCollegeName());
            }
            return  collegeIds.get(0);
        } catch (Error e) {
            // Handle the case where no college_id is found
            return -1;
        }
    }



}
