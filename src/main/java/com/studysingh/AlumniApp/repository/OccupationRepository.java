package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OccupationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Occupation> occupationRowMapper = new RowMapper<Occupation>() {
        @Override
        public Occupation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Occupation occupation = new Occupation();
            occupation.setOccupationId(rs.getInt("occupation_id"));
            occupation.setOccupationName(rs.getString("occupation_name"));
            return occupation;
        }
    };

    public List<Occupation> findAll() {
        String sql = "SELECT * FROM Occupations";
        return jdbcTemplate.query(sql, occupationRowMapper);
    }

    public Occupation findById(int occupationId) {
        String sql = "SELECT * FROM Occupations WHERE occupation_id = ?";
        return jdbcTemplate.queryForObject(sql, occupationRowMapper, occupationId);
    }

    public int save(Occupation occupation) {
        String sql = "INSERT INTO Occupations (occupation_name) VALUES (?)";
        return jdbcTemplate.update(sql, occupation.getOccupationName());
    }

    public int update(Occupation occupation) {
        String sql = "UPDATE Occupations SET occupation_name = ? WHERE occupation_id = ?";
        return jdbcTemplate.update(sql, occupation.getOccupationName(), occupation.getOccupationId());
    }

    public int deleteById(int occupationId) {
        String sql = "DELETE FROM Occupations WHERE occupation_id = ?";
        return jdbcTemplate.update(sql, occupationId);
    }

    public int getOccupationIdByName(Occupation occupation) {
        String sql = "SELECT occupation_id FROM Occupations WHERE occupation_name = ?";

        try {
            // Retrieve only the first college_id, even if there are duplicates
            List<Integer> occupationIds = jdbcTemplate.queryForList(sql, Integer.class, occupation.getOccupationName());

            // Return the first result if any, otherwise return -1
            if(occupationIds.isEmpty()){
                save(occupation);
                occupationIds = jdbcTemplate.queryForList(sql, Integer.class, occupation.getOccupationName());
            }

            return occupationIds.get(0);
        } catch (Error e) {
            // Handle the case where no occupation_id is found
            return -1;
        }
    }
}
