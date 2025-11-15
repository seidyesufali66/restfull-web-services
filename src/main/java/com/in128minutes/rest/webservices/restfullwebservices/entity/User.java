package com.in128minutes.rest.webservices.restfullwebservices.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @JsonProperty("userId")
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 30, message = "Name should have at least 2 characters")
    @Column(name = "user_name")
    @JsonProperty("userName")
    String name;
    @NotBlank(message = "date of birth is mandatory")
    @PastOrPresent(message = "Birth date must be in the past or present")
    @Column(name = "dob")
    @JsonProperty("dateOfBirth")
    private LocalDate birthDate;
    // since a user can own multiple posts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Post> posts= new ArrayList<>();
}
