package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Student;
import com.studysingh.AlumniApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.update(student);
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
