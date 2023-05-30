package com.example.homework21.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;

    private String area;

    private String street;

    private Integer buildingNumber;
}
