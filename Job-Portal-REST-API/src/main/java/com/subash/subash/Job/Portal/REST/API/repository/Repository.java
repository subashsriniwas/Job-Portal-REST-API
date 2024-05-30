package com.subash.subash.Job.Portal.REST.API.repository;

import com.subash.subash.Job.Portal.REST.API.model.JobPost;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<JobPost, Integer> {

    @Query("SELECT jp FROM JobPost jp WHERE jp.postProfile LIKE %:keyword% OR jp.postDesc LIKE %:keyword%")
    List<JobPost> findByJob_RoleContainingOrPost_DescriptionContaining(String keyword);

    @Query("SELECT jp FROM JobPost jp WHERE jp.salary >= :salary")
    List<JobPost> findBySalary(long salary);
}
