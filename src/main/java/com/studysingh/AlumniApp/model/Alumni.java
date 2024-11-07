package com.studysingh.AlumniApp.model;

public class Alumni {
    private int alumId;
    private int userId;
    private int collegeId;
    private int yearOfPassing;
    private int currentOccupationId;
    private int companyId;
    private String address;

    // Getters and Setters
    public int getAlumId() {
        return alumId;
    }

    public void setAlumId(int alumId) {
        this.alumId = alumId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public int getCurrentOccupationId() {
        return currentOccupationId;
    }

    public void setCurrentOccupationId(int currentOccupationId) {
        this.currentOccupationId = currentOccupationId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
