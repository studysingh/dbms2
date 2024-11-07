package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Alumni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlumniRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Alumni> alumniRowMapper = new RowMapper<Alumni>() {
        @Override
        public Alumni mapRow(ResultSet rs, int rowNum) throws SQLException {
            Alumni alumni = new Alumni();
            alumni.setAlumId(rs.getInt("alum_id"));
            alumni.setUserId(rs.getInt("user_id"));
            alumni.setCollegeId(rs.getInt("college_id"));
            alumni.setYearOfPassing(rs.getInt("y_o_passing"));
            alumni.setCurrentOccupationId(rs.getInt("current_occupation_id"));
            alumni.setCompanyId(rs.getInt("company_id"));
            alumni.setAddress(rs.getString("address"));
            return alumni;
        }
    };

    public List<Alumni> findAll() {
        String sql = "SELECT * FROM Alumni";
        return jdbcTemplate.query(sql, alumniRowMapper);
    }

    public Alumni findById(int alumId) {
        String sql = "SELECT * FROM Alumni WHERE alum_id = ?";
        return jdbcTemplate.queryForObject(sql, alumniRowMapper, alumId);
    }

    public int save(Alumni alumni) {
//        // Check if college exists, if not, insert it and retrieve the college ID
//        int collegeId = getCollegeIdByName();
//        if (collegeId == null) {
//            collegeId = insertCollege(alumni.getCollegeName());
//        }

//        // Check if occupation exists, if not, insert it and retrieve the occupation ID
//        Integer occupationId = getOccupationIdByName(alumni.getCurrentOccupation());
//        if (occupationId == null) {
//            occupationId = insertOccupation(alumni.getCurrentOccupation());
//        }
//
//        // Check if company exists, if not, insert it and retrieve the company ID
//        Integer companyId = getCompanyIdByName(alumni.getCompanyName());
//        if (companyId == null) {
//            companyId = insertCompany(alumni.getCompanyName());
//        }
//
//        // Set the retrieved or newly inserted IDs in the alumni object
//        alumni.setCollegeId(collegeId);
//        alumni.setCurrentOccupationId(occupationId);
//        alumni.setCompanyId(companyId);

        // check if college exist
        // if not exist save it in college table and then provide college id
        // do same for occupation id and company id assuming that functions are implemented
        String sql = "INSERT INTO Alumni (user_id, college_id, y_o_passing, current_occupation_id, company_id, address) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, alumni.getUserId(), alumni.getCollegeId(), alumni.getYearOfPassing(), alumni.getCurrentOccupationId(), alumni.getCompanyId(), alumni.getAddress());
    }

    public int update(Alumni alumni) {
        String sql = "UPDATE Alumni SET user_id = ?,  college_id = ?, y_o_passing = ?, current_occupation_id = ?, company_id = ?, address = ? WHERE alum_id = ?";
        return jdbcTemplate.update(sql, alumni.getUserId(), alumni.getCollegeId(), alumni.getYearOfPassing(), alumni.getCurrentOccupationId(), alumni.getCompanyId(), alumni.getAddress(), alumni.getAlumId());
    }

    public int deleteById(int alumId) {
        String sql = "DELETE FROM Alumni WHERE alum_id = ?";
        return jdbcTemplate.update(sql, alumId);
    }

    public Alumni getAlum(Alumni alumni) {
        // SQL query to get the alumni details based on the user_id
        String sql = "SELECT * FROM Alumni WHERE user_id = ?";

        try {
            // Querying the database using the user_id and returning a single result
            return jdbcTemplate.queryForObject(sql, alumniRowMapper, alumni.getUserId());
        } catch (Exception e) {
            // If there is an error, return null or handle the error accordingly
            return null; // Return null if no alumni record is found or in case of error
        }
    }


}
