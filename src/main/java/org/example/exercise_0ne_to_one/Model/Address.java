package org.example.exercise_0ne_to_one.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {


    @Id
    private Integer id;

    @Column(nullable = false,length = 20)
    private String area;

    @Column(nullable = false,length = 20)
    private String street;

    @Column(nullable = false)
    private String buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;



}
