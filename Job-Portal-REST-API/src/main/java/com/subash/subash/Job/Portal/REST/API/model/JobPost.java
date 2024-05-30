package com.subash.subash.Job.Portal.REST.API.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Component
@Getter
@Setter
@Entity
@Table
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Post_ID")
    private int postID;

    @JsonProperty("Job_Role")
    @Column(name = "Job_Role")
    private String postProfile;

    @JsonProperty("Post_Description")
    @Column(name = "Post_Description")
    private String postDesc;

    @JsonProperty("Required_exp")
    @Column(name = "Required_exp")
    private int reqExperience;

    @JsonProperty("Location")
    @Column(name = "Location")
    private String Location;


    @JsonProperty("Salary")
    @Column(name = "Salary")
    private long salary;

    @JsonProperty("Skills")
//    @CollectionTable(name = "job_skills", joinColumns = @JoinColumn(name = "post_id"))
//    @ElementCollection // This annotation is used to store a collection of basic types
    @Column(name = "Skills")
    private List<String> postTechStack;
}
