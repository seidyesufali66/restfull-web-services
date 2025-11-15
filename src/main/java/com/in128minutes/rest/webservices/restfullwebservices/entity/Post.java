package com.in128minutes.rest.webservices.restfullwebservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    @JsonProperty("postId")
    private Integer id;
    @Column(name="description")
    @JsonProperty("description")
    @Size(min = 10, message = "Description should have at least 10 characters")
    @NotBlank(message = "Description is mandatory")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private  User user;

}