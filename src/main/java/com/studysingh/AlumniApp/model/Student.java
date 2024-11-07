package com.studysingh.AlumniApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private int studentId;
    private int userId;
    private int yostarting;
    private int yoending;
    private int depId;
    private int collegeId;

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getYOStarting() {
        return yostarting;
    }

    public void setYOStarting(int yostarting) {
        this.yostarting = yostarting;
    }

    public int getYOEnding() {
        return yoending;
    }

    public void setYOEnding(int yoending) {
        this.yoending = yoending;
    }


    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
