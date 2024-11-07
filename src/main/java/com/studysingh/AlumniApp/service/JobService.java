package com.studysingh.AlumniApp.service;

import com.studysingh.AlumniApp.model.Job;
import com.studysingh.AlumniApp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(int jobId) {
        return jobRepository.findById(jobId);
    }

    public int addJob(Job job) {
        return jobRepository.save(job);
    }

    public void updateJob(Job job) {
        jobRepository.update(job);
    }

    public void deleteJob(int jobId) {
        jobRepository.deleteById(jobId);
    }
}
