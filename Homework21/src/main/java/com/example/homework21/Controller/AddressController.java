package com.example.homework21.Controller;

import com.example.homework21.DTO.AddressDTO;
import com.example.homework21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid@RequestBody AddressDTO dto){
        addressService.addAddress(dto);
        return ResponseEntity.status(200).body("Address added");
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress( @Valid@RequestBody AddressDTO dto){
        addressService.updateAddress(dto);
        return ResponseEntity.status(200).body("Address updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted");
    }
}
