package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Occupation;
import com.studysingh.AlumniApp.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    public List<Occupation> getAllOccupations() {
        return occupationRepository.findAll();
    }

    public Occupation getOccupationById(int occupationId) {
        return occupationRepository.findById(occupationId);
    }

    public int addOccupation(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    public int updateOccupation(Occupation occupation) {
        return occupationRepository.update(occupation);
    }

    public int deleteOccupationById(int occupationId) {
        return occupationRepository.deleteById(occupationId);
    }

    public int getOccupationIdByName(Occupation occupation) {
        return occupationRepository.getOccupationIdByName(occupation);
    }
}
