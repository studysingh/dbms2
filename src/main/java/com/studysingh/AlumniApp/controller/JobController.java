package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.Job;
import com.studysingh.AlumniApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{jobId}")
    public Job getJobById(@PathVariable int jobId) {
        return jobService.getJobById(jobId);
    }

    @PostMapping
    public int addJob(@RequestBody Job job) {
        return jobService.addJob(job);
    }

    @PutMapping("/{jobId}")
    public void updateJob(@PathVariable int jobId, @RequestBody Job job) {
        job.setJobId(jobId);
        jobService.updateJob(job);
    }

    @DeleteMapping("/{jobId}")
    public void deleteJob(@PathVariable int jobId) {
        jobService.deleteJob(jobId);
    }
}
