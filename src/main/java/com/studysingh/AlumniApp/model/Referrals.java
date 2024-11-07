package com.studysingh.AlumniApp.model;

public class Referrals {
    private int referralId;
    private int alumId;
    private int jobId;
    private int companyId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getters and Setters
    public int getReferralId() {
        return referralId;
    }

    public void setReferralId(int referralId) {
        this.referralId = referralId;
    }

    public int getAlumId() {
        return alumId;
    }

    public void setAlumId(int alumId) {
        this.alumId = alumId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
