package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.Department;
import com.studysingh.AlumniApp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") int depId) {
        return departmentService.getDepartmentById(depId);
    }

    @PostMapping
    public String addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return "Department added successfully!";
    }

    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable("id") int depId, @RequestBody Department department) {
        department.setDepId(depId);
        departmentService.updateDepartment(department);
        return "Department updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") int depId) {
        departmentService.deleteDepartmentById(depId);
        return "Department deleted successfully!";
    }
}
