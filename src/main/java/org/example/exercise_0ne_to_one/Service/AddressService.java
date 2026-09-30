package org.example.exercise_0ne_to_one.Service;

import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiException;
import org.example.exercise_0ne_to_one.Dto.AddressDto;
import org.example.exercise_0ne_to_one.Model.Address;
import org.example.exercise_0ne_to_one.Model.Teacher;
import org.example.exercise_0ne_to_one.Repository.AddressRepository;
import org.example.exercise_0ne_to_one.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

public void addAddress(AddressDto addressDto){
    Teacher teacher =teacherRepository.findTeacherById(addressDto.getTeacher_id());

    if(teacher==null){
        throw new ApiException("teacher not found");
    }

    Address address = new Address(null,
            addressDto.getArea(),
            addressDto.getStreet(),
            addressDto.getBuildingNumber(),teacher);

    addressRepository.save(address);
}


public void updateTeacher(AddressDto addressDto){
        Address address  = addressRepository.findAddressById(addressDto.getTeacher_id());

        if(address==null){
            throw new ApiException("address not found");
        }

        address.setArea(addressDto.getArea());
        address.setBuildingNumber(addressDto.getBuildingNumber());
        address.setStreet(addressDto.getStreet());
        addressRepository.save(address);
}


public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw  new ApiException("address not found");
        }

        if(address.getTeacher()!=null){
            throw new ApiException("cant delete address have teacher");
        }

        addressRepository.delete(address);
}
}
