package com.subash.subash.Job.Portal.REST.API.controller;

import com.subash.subash.Job.Portal.REST.API.model.JobPost;
import com.subash.subash.Job.Portal.REST.API.service.JobService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @PostMapping("/save")
    public String save(@RequestBody JobPost jobPost) {
        service.saveJob(jobPost);
        return "Saved";
    }

    @GetMapping("/jobs/{postId}")
    public Optional<JobPost> getJobPostById(@PathVariable Integer postId) {
        return service.getJobById(postId);
    }

    @GetMapping("/jobs")
    public List<JobPost> showAllJobs() {
        return service.show();
    }

    @PutMapping("/update")
    public String updateJobPost(@RequestBody JobPost jobPost) {
        service.updateJobPostById(jobPost);
        return "Updated";
    }

    @DeleteMapping("/delete/{postId}")
    public String deleteJobPost(@PathVariable Integer postId) {
        service.deleteByID(postId);
        return "deleted";
    }


    @GetMapping("/jobs/search/{keyword}")
    public List<JobPost> findBYKeywords(@PathVariable("keyword") String keyword) {
        return service.getByKeywords(keyword);
    }

    @GetMapping("/jobs/salary/{salary}")
    public List<JobPost> findBySalary(@PathVariable("salary") long salary) {
        return service.getBySalary(salary);
    }
}
