package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.JobDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JobDetailsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<JobDetails> jobDetailsRowMapper = new RowMapper<JobDetails>() {
        @Override
        public JobDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            JobDetails jobDetails = new JobDetails();
            jobDetails.setJobId(rs.getInt("job_id"));
            jobDetails.setJobDescription(rs.getString("job_description"));
            jobDetails.setJobLink(rs.getString("job_link"));
            return jobDetails;
        }
    };

    public JobDetails findByJobId(int jobId) {
        String sql = "SELECT * FROM JobDetails WHERE job_id = ?";
        return jdbcTemplate.queryForObject(sql, jobDetailsRowMapper, jobId);
    }

    public int save(JobDetails jobDetails) {
        String sql = "INSERT INTO JobDetails (job_id, job_description, job_link) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, jobDetails.getJobId(), jobDetails.getJobDescription(), jobDetails.getJobLink());
    }

    public int update(JobDetails jobDetails) {
        String sql = "UPDATE JobDetails SET job_description = ?, job_link = ? WHERE job_id = ?";
        return jdbcTemplate.update(sql, jobDetails.getJobDescription(), jobDetails.getJobLink(), jobDetails.getJobId());
    }

    public int deleteByJobId(int jobId) {
        String sql = "DELETE FROM JobDetails WHERE job_id = ?";
        return jdbcTemplate.update(sql, jobId);
    }
}
