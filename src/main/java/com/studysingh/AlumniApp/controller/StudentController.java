package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.Student;
import com.studysingh.AlumniApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        System.out.println("It is ok");
        System.out.println(student.getUserId());
        System.out.println(student.getYOStarting());
        System.out.println(student.getYOEnding());
        System.out.println(student.getDepId());
        System.out.println(student.getCollegeId());
        studentService.addStudent(student);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }
}
