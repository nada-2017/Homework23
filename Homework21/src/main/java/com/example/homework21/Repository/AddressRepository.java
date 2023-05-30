package com.example.homework21.Repository;

import com.example.homework21.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address getAddressById(Integer id);
}
