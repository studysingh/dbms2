package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.User;
import com.studysingh.AlumniApp.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @PostMapping
    public String createCollege(@RequestBody College college) {
        collegeService.saveCollege(college);
        return "College created successfully";
    }

    @PostMapping("/getId")
    public int getCollegeIdByCollegeName(@RequestBody College college) {
        return collegeService.getCollegeIdByCollegeName(college);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Integer id) {
        collegeService.deleteCollegeById(id);
        return ResponseEntity.noContent().build();
    }
}
