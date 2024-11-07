package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.Skills;
import com.studysingh.AlumniApp.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @GetMapping("/student/{studentId}")
    public List<Skills> getSkillsByStudent(@PathVariable int studentId) {
        return skillsService.getSkillsByStudentId(studentId);
    }

    @PostMapping
    public void addSkill(@RequestBody Skills skill) {
        skillsService.addSkill(skill);
    }

    @PostMapping("/student/{studentId}/add")
    public void addSkillToStudent(@PathVariable int studentId, @RequestParam int skillId) {
        skillsService.addSkillToStudent(studentId, skillId);
    }

    @DeleteMapping("/student/{studentId}/remove")
    public void removeSkillFromStudent(@PathVariable int studentId, @RequestParam int skillId) {
        skillsService.removeSkillFromStudent(studentId, skillId);
    }

    @DeleteMapping("/{skillId}")
    public void deleteSkill(@PathVariable int skillId) {
        skillsService.deleteSkill(skillId);
    }
}
