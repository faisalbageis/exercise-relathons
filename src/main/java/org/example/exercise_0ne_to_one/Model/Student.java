package org.example.exercise_0ne_to_one.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @NotEmpty(message = "name can not be empty")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "age can not be null")
    private Integer age;

    @Column(nullable = false)
    @NotEmpty(message = "major can not be empty")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
