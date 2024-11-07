package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Referrals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReferralsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Referrals> referralsRowMapper = new RowMapper<Referrals>() {
        @Override
        public Referrals mapRow(ResultSet rs, int rowNum) throws SQLException {
            Referrals referrals = new Referrals();
            referrals.setReferralId(rs.getInt("referral_id"));
            referrals.setAlumId(rs.getInt("alum_id"));
            referrals.setJobId(rs.getInt("job_id"));
            referrals.setCompanyId(rs.getInt("company_id"));
            referrals.setUserId(rs.getInt("user_id"));
            return referrals;
        }
    };

    public List<Referrals> findAll() {
        String sql = "SELECT * FROM Referrals";
        return jdbcTemplate.query(sql, referralsRowMapper);
    }

    public Referrals findById(int referralId) {
        String sql = "SELECT * FROM Referrals WHERE referral_id = ?";
        return jdbcTemplate.queryForObject(sql, referralsRowMapper, referralId);
    }

    public int save(Referrals referrals) {
        String sql = "INSERT INTO Referrals (alum_id, job_id, company_id , user_id) VALUES (?, ? , ?, ?)";
        return jdbcTemplate.update(sql, referrals.getAlumId(), referrals.getJobId(), referrals.getCompanyId() , referrals.getUserId());
    }

    public int update(Referrals referrals) {
        String sql = "UPDATE Referrals SET alum_id = ?, job_id = ?, company_id = ? WHERE referral_id = ?";
        return jdbcTemplate.update(sql, referrals.getAlumId(), referrals.getJobId(), referrals.getCompanyId(), referrals.getReferralId());
    }

    public int deleteById(int referralId) {
        String sql = "DELETE FROM Referrals WHERE referral_id = ?";
        return jdbcTemplate.update(sql, referralId);
    }
}
