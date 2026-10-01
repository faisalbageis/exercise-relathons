package org.example.exercise_0ne_to_one.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false,length = 25)
    @NotEmpty(message = "name can not be empty")
    @Size(min = 4,max = 25,message = "name size must be between 4 and 25")
    private String name;


    @Column(nullable = false)
    @NotNull(message = "age can not be empty")
    @Min(value = 18,message = "age can not be less than 18")
    private Integer age;

    @Column(nullable = false,length = 50)
    @NotEmpty(message = "email can not be empty")
    @Size(max = 50,message = "email length must be less than 50")
    @Email(message = "in valid email")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "salary can not be empty")
    @Min(value = 4000,message = "the minimum value ")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;
}
