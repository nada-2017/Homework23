package com.example.homework21.Service;

import com.example.homework21.ApiException.ApiException;
import com.example.homework21.DTO.AddressDTO;
import com.example.homework21.Model.Address;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.AddressRepository;
import com.example.homework21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO dto){
        Teacher t = teacherRepository.getTeacherById(dto.getTeacher_id());
        if (t == null)
            throw new ApiException("unable to add address, teacher not found");
        Address a = new Address(null,dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), t);
        addressRepository.save(a);
    }

    public void updateAddress(AddressDTO dto){
        Address a = addressRepository.getAddressById(dto.getTeacher_id());
        //Teacher t = teacherRepository.getTeacherById(teacherId);
        if (a == null)
            throw new ApiException("Address not found");
        a.setArea(dto.getArea());
        a.setStreet(dto.getStreet());
        a.setBuildingNumber(dto.getBuildingNumber());
        a.setTeacher(teacherRepository.getTeacherById(dto.getTeacher_id()));
        addressRepository.save(a);
    }

    public void deleteAddress(Integer id){
        Address a = addressRepository.getAddressById(id);
        if (a == null)
            throw new ApiException("Address not found");
        addressRepository.delete(a);
    }

}
