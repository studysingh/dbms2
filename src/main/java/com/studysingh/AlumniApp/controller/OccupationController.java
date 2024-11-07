package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.Occupation;
import com.studysingh.AlumniApp.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/occupations")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @GetMapping
    public List<Occupation> getAllOccupations() {
        return occupationService.getAllOccupations();
    }

    @GetMapping("/{id}")
    public Occupation getOccupationById(@PathVariable("id") int occupationId) {
        return occupationService.getOccupationById(occupationId);
    }

    @PostMapping
    public String addOccupation(@RequestBody Occupation occupation) {
        occupationService.addOccupation(occupation);
        return "Occupation added successfully!";
    }

    @PutMapping("/{id}")
    public String updateOccupation(@PathVariable("id") int occupationId, @RequestBody Occupation occupation) {
        occupation.setOccupationId(occupationId);
        occupationService.updateOccupation(occupation);
        return "Occupation updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteOccupation(@PathVariable("id") int occupationId) {
        occupationService.deleteOccupationById(occupationId);
        return "Occupation deleted successfully!";
    }

    @PostMapping("/getId")
    public int getOccupationIdByName(@RequestBody Occupation occupation) {
        return occupationService.getOccupationIdByName(occupation);
    }
}
