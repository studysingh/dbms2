package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.TypesOfJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypesOfJobsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<TypesOfJobs> typesOfJobsRowMapper = new RowMapper<TypesOfJobs>() {
        @Override
        public TypesOfJobs mapRow(ResultSet rs, int rowNum) throws SQLException {
            TypesOfJobs typesOfJobs = new TypesOfJobs();
            typesOfJobs.setTypeId(rs.getInt("type_id"));
            typesOfJobs.setJobType(rs.getString("job_type"));
            return typesOfJobs;
        }
    };

    public List<TypesOfJobs> findAll() {
        String sql = "SELECT * FROM TypesOfJobs";
        return jdbcTemplate.query(sql, typesOfJobsRowMapper);
    }

    public TypesOfJobs findById(int typeId) {
        String sql = "SELECT * FROM TypesOfJobs WHERE type_id = ?";
        return jdbcTemplate.queryForObject(sql, typesOfJobsRowMapper, typeId);
    }

    public int save(TypesOfJobs typesOfJobs) {
        String sql = "INSERT INTO TypesOfJobs (job_type) VALUES (?)";
        return jdbcTemplate.update(sql, typesOfJobs.getJobType());
    }

    public int update(TypesOfJobs typesOfJobs) {
        String sql = "UPDATE TypesOfJobs SET job_type = ? WHERE type_id = ?";
        return jdbcTemplate.update(sql, typesOfJobs.getJobType(), typesOfJobs.getTypeId());
    }

    public int deleteById(int typeId) {
        String sql = "DELETE FROM TypesOfJobs WHERE type_id = ?";
        return jdbcTemplate.update(sql, typeId);
    }
}
