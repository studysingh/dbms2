package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Company> companyRowMapper = new RowMapper<Company>() {
        @Override
        public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
            Company company = new Company();
            company.setCompanyId(rs.getInt("company_id"));
            company.setCompanyName(rs.getString("company_name"));
            return company;
        }
    };

    public List<Company> findAll() {
        String sql = "SELECT * FROM Companies";
        return jdbcTemplate.query(sql, companyRowMapper);
    }

    public Company findById(int companyId) {
        String sql = "SELECT * FROM Companies WHERE company_id = ?";
        return jdbcTemplate.queryForObject(sql, companyRowMapper, companyId);
    }

    public int save(Company company) {
        String sql = "INSERT INTO Companies (company_name) VALUES (?) ";
        return jdbcTemplate.update(sql, company.getCompanyName());
    }

    public int update(Company company) {
        String sql = "UPDATE Companies SET company_name = ? WHERE company_id = ?";
        return jdbcTemplate.update(sql, company.getCompanyName(),  company.getCompanyId());
    }

    public int deleteById(int companyId) {
        String sql = "DELETE FROM Companies WHERE company_id = ?";
        return jdbcTemplate.update(sql, companyId);
    }

    public int getCompanyNameByCompanyId(Company company) {
            String sql = "SELECT company_id FROM Companies WHERE company_name = ?";

            try {
                // Retrieve only the first college_id, even if there are duplicates
                List<Integer> companyIds = jdbcTemplate.queryForList(sql, Integer.class, company.getCompanyName());

                if(companyIds.isEmpty()){
                    save(company);
                    companyIds = jdbcTemplate.queryForList(sql, Integer.class, company.getCompanyName());
                }
                // Return the first result if any, otherwise return -1
                return companyIds.get(0);

            } catch (Error e) {
                // Handle the case where no college_id is found
                return -1;
            }
    }
}
