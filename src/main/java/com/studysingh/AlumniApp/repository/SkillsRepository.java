package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SkillsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Skills> skillsRowMapper = new RowMapper<Skills>() {
        @Override
        public Skills mapRow(ResultSet rs, int rowNum) throws SQLException {
            Skills skill = new Skills();
            skill.setSkillId(rs.getInt("skill_id"));
            skill.setSkillName(rs.getString("skill_name"));
            return skill;
        }
    };

    public List<Skills> findAll() {
        String sql = "SELECT * FROM Skills";
        return jdbcTemplate.query(sql, skillsRowMapper);
    }

    public Skills findById(int skillId) {
        String sql = "SELECT * FROM Skills WHERE skill_id = ?";
        return jdbcTemplate.queryForObject(sql, skillsRowMapper, skillId);
    }

    public int save(Skills skill) {
        String sql = "INSERT INTO Skills (skill_name) VALUES (?)";
        return jdbcTemplate.update(sql, skill.getSkillName());
    }

    public int deleteById(int skillId) {
        String sql = "DELETE FROM Skills WHERE skill_id = ?";
        return jdbcTemplate.update(sql, skillId);
    }

    public List<Skills> findSkillsByStudentId(int studentId) {
        String sql = "SELECT s.skill_id, s.skill_name FROM Skills s INNER JOIN StudentSkills ss ON s.skill_id = ss.skill_id WHERE ss.student_id = ?";
        return jdbcTemplate.query(sql, skillsRowMapper, studentId);
    }

    public int addSkillToStudent(int studentId, int skillId) {
        String sql = "INSERT INTO StudentSkills (student_id, skill_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, studentId, skillId);
    }

    public int removeSkillFromStudent(int studentId, int skillId) {
        String sql = "DELETE FROM StudentSkills WHERE student_id = ? AND skill_id = ?";
        return jdbcTemplate.update(sql, studentId, skillId);
    }
}
