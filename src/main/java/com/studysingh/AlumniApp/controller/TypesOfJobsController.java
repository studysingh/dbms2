package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.TypesOfJobs;
import com.studysingh.AlumniApp.service.TypesOfJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typesofjobs")
public class TypesOfJobsController {

    @Autowired
    private TypesOfJobsService typesOfJobsService;

    @GetMapping
    public List<TypesOfJobs> getAllTypesOfJobs() {
        return typesOfJobsService.getAllTypesOfJobs();
    }

    @GetMapping("/{typeId}")
    public TypesOfJobs getTypesOfJobById(@PathVariable int typeId) {
        return typesOfJobsService.getTypesOfJobById(typeId);
    }

    @PostMapping
    public void addTypesOfJob(@RequestBody TypesOfJobs typesOfJobs) {
        typesOfJobsService.addTypesOfJob(typesOfJobs);
    }

    @PutMapping("/{typeId}")
    public void updateTypesOfJob(@PathVariable int typeId, @RequestBody TypesOfJobs typesOfJobs) {
        typesOfJobs.setTypeId(typeId);
        typesOfJobsService.updateTypesOfJob(typesOfJobs);
    }

    @DeleteMapping("/{typeId}")
    public void deleteTypesOfJob(@PathVariable int typeId) {
        typesOfJobsService.deleteTypesOfJob(typeId);
    }
}
