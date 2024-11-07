package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Alumni;
import com.studysingh.AlumniApp.repository.AlumniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumniService {

    @Autowired
    private AlumniRepository alumniRepository;

    public List<Alumni> getAllAlumni() {
        return alumniRepository.findAll();
    }

    public Alumni getAlumniById(int alumId) {
        return alumniRepository.findById(alumId);
    }

    public void addAlumni(Alumni alumni) {
        alumniRepository.save(alumni);
    }

    public void updateAlumni(Alumni alumni) {
        alumniRepository.update(alumni);
    }

    public void deleteAlumni(int alumId) {
        alumniRepository.deleteById(alumId);
    }

    public Alumni getAlum(Alumni alumni) {
        return alumniRepository.getAlum(alumni);
    }
}
