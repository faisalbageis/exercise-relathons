package org.example.exercise_0ne_to_one.Repository;

import org.example.exercise_0ne_to_one.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address findAddressById(Integer id);
}
