package org.example.exercise_0ne_to_one.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {


    private Integer teacher_id;



    @NotEmpty(message = "area can not be empty")
    @Size(min = 4,max = 20,message = "area length must be between 4 and 20")
    private String area;


    @NotEmpty(message = "street can not be empty")
    @Size(min = 4,max = 20,message = "street length must be between 4 and 20")
    private String street;


    @NotEmpty(message = "buildingNumber can not be empty")
    @Size(max = 6 ,message = "buildingNumber length must be less than 6")
    private String buildingNumber;


}
