package com.subash.subash.Job.Portal.REST.API.service;

import com.subash.subash.Job.Portal.REST.API.model.JobPost;
import com.subash.subash.Job.Portal.REST.API.repository.Repository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private Repository repository;

    public void saveJob(JobPost jobPost) {
        repository.save(jobPost);
    }

    public List<JobPost> show() {
        return repository.findAll();
    }

    @Transactional
    public Optional<JobPost> getJobById(int postId) {
        return repository.findById(postId);
    }

    @Transactional
    public void updateJobPostById(JobPost jobPost) {
        JobPost jp = new JobPost();
        jp.setPostID(jobPost.getPostID());
        jp.setPostProfile(jobPost.getPostProfile());
        jp.setPostDesc(jobPost.getPostDesc());
        jp.setReqExperience(jobPost.getReqExperience());
        jp.setPostTechStack(jobPost.getPostTechStack());
        repository.save(jp);
    }

    public void deleteByID(Integer postId) {
        repository.deleteById(postId);
    }

    public List<JobPost> getByKeywords(String keyword) {
        return repository.findByJob_RoleContainingOrPost_DescriptionContaining(keyword);
    }

    public List<JobPost> getBySalary (long salary) {
        return repository.findBySalary(salary);
    }
}
