package org.example.exercise_0ne_to_one.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exercise_0ne_to_one.Api.ApiResponse;
import org.example.exercise_0ne_to_one.Dto.AddressDto;
import org.example.exercise_0ne_to_one.Model.Address;
import org.example.exercise_0ne_to_one.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private  final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity<?> getAddresses(){
        List<Address> addresses = addressService.getAddresses();
        return ResponseEntity.status(200).body(addresses);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDto addressDto){
        addressService.addAddress(addressDto);
        return ResponseEntity.status(200).body(new ApiResponse("address added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDto addressDto){
        addressService.updateTeacher(addressDto);
        return ResponseEntity.status(200).body(new ApiResponse("address updated successfully"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted successfully"));
    }
}
