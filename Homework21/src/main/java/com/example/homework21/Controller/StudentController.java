package com.example.homework21.Controller;

import com.example.homework21.Model.Student;
import com.example.homework21.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(studentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid@RequestBody Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("Student updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted");
    }

    @PutMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity assign(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId, courseId);
        return ResponseEntity.status(200).body("Assignment completed");
    }

    @PutMapping("/major/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id, @PathVariable String major){
        studentService.changeMajor(id, major);
        return ResponseEntity.status(200).body("Major has been changed");
    }
}
