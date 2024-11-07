package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.StudentProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<StudentProject> studentProjectRowMapper = new RowMapper<StudentProject>() {
        @Override
        public StudentProject mapRow(ResultSet rs, int rowNum) throws SQLException {
            StudentProject project = new StudentProject();
            project.setProjectId(rs.getInt("project_id"));
            project.setStudentId(rs.getInt("student_id"));
            project.setProjectTitle(rs.getString("project_title"));
            project.setProjectDescription(rs.getString("project_description"));
            project.setStartDate(rs.getDate("start_date"));
            project.setEndDate(rs.getDate("end_date"));
            return project;
        }
    };

    public List<StudentProject> findAll() {
        String sql = "SELECT * FROM StudentProjects";
        return jdbcTemplate.query(sql, studentProjectRowMapper);
    }

    public StudentProject findById(int projectId) {
        String sql = "SELECT * FROM StudentProjects WHERE project_id = ?";
        return jdbcTemplate.queryForObject(sql, studentProjectRowMapper, projectId);
    }

    public int save(StudentProject project) {
        String sql = "INSERT INTO StudentProjects (student_id, project_title, project_description, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, project.getStudentId(), project.getProjectTitle(), project.getProjectDescription(), project.getStartDate(), project.getEndDate());
    }

    public int update(StudentProject project) {
        String sql = "UPDATE StudentProjects SET student_id = ?, project_title = ?, project_description = ?, start_date = ?, end_date = ? WHERE project_id = ?";
        return jdbcTemplate.update(sql, project.getStudentId(), project.getProjectTitle(), project.getProjectDescription(), project.getStartDate(), project.getEndDate(), project.getProjectId());
    }

    public int deleteById(int projectId) {
        String sql = "DELETE FROM StudentProjects WHERE project_id = ?";
        return jdbcTemplate.update(sql, projectId);
    }
}
