package org.example.exercise_0ne_to_one.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "name can not be empty")
    private String name;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany
    @JsonIgnore
    private Set<Student> students;
}
