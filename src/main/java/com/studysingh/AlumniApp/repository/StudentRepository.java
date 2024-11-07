package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setStudentId(rs.getInt("student_id"));
            student.setUserId(rs.getInt("user_id"));
            student.setYOStarting(rs.getInt("y_o_starting"));
            student.setYOEnding(rs.getInt("y_o_ending"));
            student.setDepId(rs.getInt("dep_id"));
            student.setCollegeId(rs.getInt("college_id"));
            return student;
        }
    };

    public List<Student> findAll() {
        String sql = "SELECT * FROM Students";
        return jdbcTemplate.query(sql, studentRowMapper);
    }

    public Student findById(int studentId) {
        String sql = "SELECT * FROM Students WHERE student_id = ?";
        return jdbcTemplate.queryForObject(sql, studentRowMapper, studentId);
    }

    public int save(Student student) {
        String sql = "INSERT INTO Students (user_id, y_o_starting, y_o_ending, dep_id, college_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, student.getUserId(), student.getYOStarting(), student.getYOEnding(),
                 student.getDepId(), student.getCollegeId());
    }

    public int update(Student student) {
        String sql = "UPDATE Students SET user_id = ?, y_o_starting = ?, y_o_ending = ?, " +
                " dep_id = ?, college_id = ? WHERE student_id = ?";
        return jdbcTemplate.update(sql, student.getUserId(), student.getYOStarting(), student.getYOEnding(),
                 student.getDepId(), student.getCollegeId(), student.getStudentId());
    }

    public int deleteById(int studentId) {
        String sql = "DELETE FROM Students WHERE student_id = ?";
        return jdbcTemplate.update(sql, studentId);
    }
}
