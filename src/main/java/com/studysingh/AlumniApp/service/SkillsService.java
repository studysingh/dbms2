package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Skills;
import com.studysingh.AlumniApp.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    public List<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }

    public List<Skills> getSkillsByStudentId(int studentId) {
        return skillsRepository.findSkillsByStudentId(studentId);
    }

    public Skills getSkillById(int skillId) {
        return skillsRepository.findById(skillId);
    }

    public void addSkill(Skills skill) {
        skillsRepository.save(skill);
    }

    public void addSkillToStudent(int studentId, int skillId) {
        skillsRepository.addSkillToStudent(studentId, skillId);
    }

    public void removeSkillFromStudent(int studentId, int skillId) {
        skillsRepository.removeSkillFromStudent(studentId, skillId);
    }

    public void deleteSkill(int skillId) {
        skillsRepository.deleteById(skillId);
    }
}
