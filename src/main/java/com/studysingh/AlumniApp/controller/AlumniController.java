package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.Alumni;
import com.studysingh.AlumniApp.service.AlumniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumni")
public class AlumniController {

    @Autowired
    private AlumniService alumniService;

    @GetMapping
    public List<Alumni> getAllAlumni() {
        return alumniService.getAllAlumni();
    }

    @GetMapping("/{alumId}")
    public Alumni getAlumniById(@PathVariable int alumId) {
        return alumniService.getAlumniById(alumId);
    }

    @PostMapping
    public void addAlumni(@RequestBody Alumni alumni) {
        alumniService.addAlumni(alumni);
    }

    @PutMapping("/{alumId}")
    public void updateAlumni(@PathVariable int alumId, @RequestBody Alumni alumni) {
        alumni.setAlumId(alumId);
        alumniService.updateAlumni(alumni);
    }

    @DeleteMapping("/{alumId}")
    public void deleteAlumni(@PathVariable int alumId) {
        alumniService.deleteAlumni(alumId);
    }

    @PostMapping("/{getAlum}")
    public Alumni getAlum(@RequestBody Alumni alumni) {
       return alumniService.getAlum(alumni);
    }
}
