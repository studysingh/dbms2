package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.StudentProject;
import com.studysingh.AlumniApp.service.StudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-projects")
public class StudentProjectController {

    @Autowired
    private StudentProjectService studentProjectService;

    @GetMapping
    public List<StudentProject> getAllProjects() {
        return studentProjectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public StudentProject getProjectById(@PathVariable int projectId) {
        return studentProjectService.getProjectById(projectId);
    }

    @PostMapping
    public void addProject(@RequestBody StudentProject project) {
        studentProjectService.addProject(project);
    }

    @PutMapping("/{projectId}")
    public void updateProject(@PathVariable int projectId, @RequestBody StudentProject project) {
        project.setProjectId(projectId);
        studentProjectService.updateProject(project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable int projectId) {
        studentProjectService.deleteProject(projectId);
    }
}
