package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.Locations;
import com.studysingh.AlumniApp.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping
    public List<Locations> getAllLocations() {
        return locationsService.getAllLocations();
    }

    @GetMapping("/{locationId}")
    public Locations getLocationById(@PathVariable int locationId) {
        return locationsService.getLocationById(locationId);
    }

    @PostMapping
    public void addLocation(@RequestBody Locations location) {
        locationsService.addLocation(location);
    }

    @PutMapping("/{locationId}")
    public void updateLocation(@PathVariable int locationId, @RequestBody Locations location) {
        location.setLocationId(locationId);
        locationsService.updateLocation(location);
    }

    @DeleteMapping("/{locationId}")
    public void deleteLocation(@PathVariable int locationId) {
        locationsService.deleteLocation(locationId);
    }

    @PostMapping("/getId")
    public int getLocationsIdByDetails(@RequestBody Locations location) {
        return locationsService.getLocationsIdByDetails(location);
    }
}
