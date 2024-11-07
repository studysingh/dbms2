package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public int saveCollege(College college) {
        return collegeRepository.save(college);
    }

    public void deleteCollegeById(Integer id) {
        collegeRepository.deleteById(id);
    }

    public int getCollegeIdByCollegeName(College college) {
        return collegeRepository.getCollegeIdByCollegeName(college);
    }
}
