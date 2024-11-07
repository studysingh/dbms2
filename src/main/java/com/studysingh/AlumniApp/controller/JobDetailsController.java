package com.studysingh.AlumniApp.controller;

import com.studysingh.AlumniApp.model.JobDetails;
import com.studysingh.AlumniApp.service.JobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobdetails")
public class JobDetailsController {

    @Autowired
    private JobDetailsService jobDetailsService;

    @GetMapping("/{jobId}")
    public JobDetails getJobDetails(@PathVariable int jobId) {
        return jobDetailsService.getJobDetailsByJobId(jobId);
    }

    @PostMapping
    public void addJobDetails(@RequestBody JobDetails jobDetails) {
        jobDetailsService.addJobDetails(jobDetails);
    }

    @PutMapping("/{jobId}")
    public void updateJobDetails(@PathVariable int jobId, @RequestBody JobDetails jobDetails) {
        jobDetails.setJobId(jobId);
        jobDetailsService.updateJobDetails(jobDetails);
    }

    @DeleteMapping("/{jobId}")
    public void deleteJobDetails(@PathVariable int jobId) {
        jobDetailsService.deleteJobDetails(jobId);
    }
}
