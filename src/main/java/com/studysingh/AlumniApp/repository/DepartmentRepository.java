package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Company;
import com.studysingh.AlumniApp.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Department> departmentRowMapper = new RowMapper<Department>() {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();
            department.setDepId(rs.getInt("dep_id"));
            department.setDepName(rs.getString("dep_name"));
            return department;
        }
    };

    public List<Department> findAll() {
        String sql = "SELECT * FROM Departments";
        return jdbcTemplate.query(sql, departmentRowMapper);
    }

    public Department findById(int depId) {
        String sql = "SELECT * FROM Departments WHERE dep_id = ?";
        return jdbcTemplate.queryForObject(sql, departmentRowMapper, depId);
    }

    public int save(Department department) {
        String sql = "INSERT INTO Departments (dep_name) VALUES (?)";
        return jdbcTemplate.update(sql, department.getDepName());
    }

    public int update(Department department) {
        String sql = "UPDATE Departments SET dep_name = ? WHERE dep_id = ?";
        return jdbcTemplate.update(sql, department.getDepName(), department.getDepId());
    }

    public int deleteById(int depId) {
        String sql = "DELETE FROM Departments WHERE dep_id = ?";
        return jdbcTemplate.update(sql, depId);
    }



}
