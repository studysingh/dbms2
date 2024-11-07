package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.StudentProject;
import com.studysingh.AlumniApp.repository.StudentProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProjectService {

    @Autowired
    private StudentProjectRepository studentProjectRepository;

    public List<StudentProject> getAllProjects() {
        return studentProjectRepository.findAll();
    }

    public StudentProject getProjectById(int projectId) {
        return studentProjectRepository.findById(projectId);
    }

    public void addProject(StudentProject project) {
        studentProjectRepository.save(project);
    }

    public void updateProject(StudentProject project) {
        studentProjectRepository.update(project);
    }

    public void deleteProject(int projectId) {
        studentProjectRepository.deleteById(projectId);
    }
}
