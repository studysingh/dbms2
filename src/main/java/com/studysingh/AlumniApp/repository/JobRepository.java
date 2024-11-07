package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JobRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Job> jobRowMapper = new RowMapper<Job>() {
        @Override
        public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
            Job job = new Job();
            job.setJobId(rs.getInt("job_id"));
            job.setJobTitle(rs.getString("job_title"));
            job.setJobPosition(rs.getString("job_position"));
            job.setStatus(rs.getString("status"));
            job.setStipend(rs.getInt("stipend"));
            job.setLocationId(rs.getInt("location_id"));
            job.setCompanyId(rs.getInt("company_id"));
            job.setJobTypeId(rs.getInt("job_type_id"));
            job.setAlumId(rs.getInt("alum_id"));
            return job;
        }
    };

    public List<Job> findAll() {
        String sql = "SELECT * FROM Jobs";
        return jdbcTemplate.query(sql, jobRowMapper);
    }

    public Job findById(int jobId) {
        String sql = "SELECT * FROM Jobs WHERE job_id = ?";
        return jdbcTemplate.queryForObject(sql, jobRowMapper, jobId);
    }

    public int save(Job job) {
        // SQL query to insert the job into the Jobs table
        String sqlInsert = "INSERT INTO Jobs (job_title, job_position, status, stipend, location_id, company_id, job_type_id, alum_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Insert the job into the database
        jdbcTemplate.update(sqlInsert, job.getJobTitle(), job.getJobPosition(), job.getStatus(),
                job.getStipend(), job.getLocationId(), job.getCompanyId(),
                job.getJobTypeId(), job.getAlumId());

        // Now, query to fetch the generated job_id based on the unique parameters (assuming these are unique)
        String sqlSelect = "SELECT job_id FROM Jobs WHERE job_title = ? AND job_position = ? AND status = ? " +
                "AND stipend = ? AND location_id = ? AND company_id = ? AND job_type_id = ? AND alum_id = ?";
        List<Integer> jobIds = jdbcTemplate.queryForList(sqlSelect, Integer.class, job.getJobTitle(), job.getJobPosition(),
                job.getStatus(), job.getStipend(), job.getLocationId(),
                job.getCompanyId(), job.getJobTypeId(), job.getAlumId());
        return jobIds.get(0);
    }


    public int update(Job job) {
        String sql = "UPDATE Jobs SET job_title = ?, job_position = ?, status = ?, stipend = ?, location_id = ?, company_id = ?, job_type_id = ?, alum_id = ? WHERE job_id = ?";
        return jdbcTemplate.update(sql, job.getJobTitle(), job.getJobPosition(), job.getStatus(),
                job.getStipend(), job.getLocationId(), job.getCompanyId(), job.getJobTypeId(), job.getAlumId(), job.getJobId());
    }

    public int deleteById(int jobId) {
        String sql = "DELETE FROM Jobs WHERE job_id = ?";
        return jdbcTemplate.update(sql, jobId);
    }
}
