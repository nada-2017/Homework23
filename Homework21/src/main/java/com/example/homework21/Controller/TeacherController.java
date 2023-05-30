package com.example.homework21.Controller;

import com.example.homework21.Model.Teacher;
import com.example.homework21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllT(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addT(@RequestBody@Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateT(@PathVariable Integer id, @RequestBody@Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteT(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    @GetMapping("/get-teacher/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacher(id));
    }
}
