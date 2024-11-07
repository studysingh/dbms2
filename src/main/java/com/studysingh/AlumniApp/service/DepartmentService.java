package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Department;
import com.studysingh.AlumniApp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int depId) {
        return departmentRepository.findById(depId);
    }

    public int addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public int updateDepartment(Department department) {
        return departmentRepository.update(department);
    }

    public int deleteDepartmentById(int depId) {
        return departmentRepository.deleteById(depId);
    }
}
