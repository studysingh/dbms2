package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.Locations;
import com.studysingh.AlumniApp.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository locationsRepository;

    public List<Locations> getAllLocations() {
        return locationsRepository.findAll();
    }

    public Locations getLocationById(int locationId) {
        return locationsRepository.findById(locationId);
    }

    public void addLocation(Locations location) {
        locationsRepository.save(location);
    }

    public void updateLocation(Locations location) {
        locationsRepository.update(location);
    }

    public void deleteLocation(int locationId) {
        locationsRepository.deleteById(locationId);
    }

    public int getLocationsIdByDetails(Locations location) {
            return locationsRepository.getLocationsIdByDetails(location);
    }
}
