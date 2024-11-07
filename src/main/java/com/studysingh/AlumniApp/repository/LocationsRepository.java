package com.studysingh.AlumniApp.repository;

import com.studysingh.AlumniApp.model.College;
import com.studysingh.AlumniApp.model.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Locations> locationsRowMapper = new RowMapper<Locations>() {
        @Override
        public Locations mapRow(ResultSet rs, int rowNum) throws SQLException {
            Locations location = new Locations();
            location.setLocationId(rs.getInt("location_id"));
            location.setCity(rs.getString("city"));
            location.setCountry(rs.getString("country"));
            location.setAddress(rs.getString("address"));
            return location;
        }
    };

    public List<Locations> findAll() {
        String sql = "SELECT * FROM Locations";
        return jdbcTemplate.query(sql, locationsRowMapper);
    }

    public Locations findById(int locationId) {
        String sql = "SELECT * FROM Locations WHERE location_id = ?";
        return jdbcTemplate.queryForObject(sql, locationsRowMapper, locationId);
    }

    public int save(Locations location) {
        String sql = "INSERT INTO Locations (city, country, address) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, location.getCity(), location.getCountry(), location.getAddress());
    }

    public int update(Locations location) {
        String sql = "UPDATE Locations SET city = ?, country = ?, address = ? WHERE location_id = ?";
        return jdbcTemplate.update(sql, location.getCity(), location.getCountry(), location.getAddress(), location.getLocationId());
    }

    public int deleteById(int locationId) {
        String sql = "DELETE FROM Locations WHERE location_id = ?";
        return jdbcTemplate.update(sql, locationId);
    }

    public int getLocationsIdByDetails(Locations location) {
        String sql = "SELECT location_id FROM Locations WHERE city = ? AND country = ? AND address = ?";
        try {
            // Retrieve the location_id based on the city, country, and address
            List<Integer> locationIds = jdbcTemplate.queryForList(sql, Integer.class, location.getCity(), location.getCountry(), location.getAddress());

            // Return the first result if any, otherwise return 0
            if(locationIds.isEmpty()){
                save(location);  // Assuming you want to save the location if it doesn't exist
                locationIds = jdbcTemplate.queryForList(sql, Integer.class, location.getCity(), location.getCountry(), location.getAddress());
            }
            return locationIds.get(0); // Return 0 if no location found
        } catch (Exception e) {
            // Handle any SQL or data issues by returning -1
            return -1;
        }
    }

}
