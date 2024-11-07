package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.TypesOfJobs;
import com.studysingh.AlumniApp.repository.TypesOfJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesOfJobsService {

    @Autowired
    private TypesOfJobsRepository typesOfJobsRepository;

    public List<TypesOfJobs> getAllTypesOfJobs() {
        return typesOfJobsRepository.findAll();
    }

    public TypesOfJobs getTypesOfJobById(int typeId) {
        return typesOfJobsRepository.findById(typeId);
    }

    public void addTypesOfJob(TypesOfJobs typesOfJobs) {
        typesOfJobsRepository.save(typesOfJobs);
    }

    public void updateTypesOfJob(TypesOfJobs typesOfJobs) {
        typesOfJobsRepository.update(typesOfJobs);
    }

    public void deleteTypesOfJob(int typeId) {
        typesOfJobsRepository.deleteById(typeId);
    }
}
