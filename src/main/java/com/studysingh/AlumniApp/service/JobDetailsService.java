package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.JobDetails;
import com.studysingh.AlumniApp.repository.JobDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobDetailsService {

    @Autowired
    private JobDetailsRepository jobDetailsRepository;

    public JobDetails getJobDetailsByJobId(int jobId) {
        return jobDetailsRepository.findByJobId(jobId);
    }

    public void addJobDetails(JobDetails jobDetails) {
        jobDetailsRepository.save(jobDetails);
    }

    public void updateJobDetails(JobDetails jobDetails) {
        jobDetailsRepository.update(jobDetails);
    }

    public void deleteJobDetails(int jobId) {
        jobDetailsRepository.deleteByJobId(jobId);
    }
}
