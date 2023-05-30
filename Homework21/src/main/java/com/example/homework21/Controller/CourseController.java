package com.example.homework21.Controller;

import com.example.homework21.Model.Course;
import com.example.homework21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid@RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("Course updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted");
    }

    @PutMapping("/assign/{teacherId}/{courseId}")
    public ResponseEntity assign(@PathVariable Integer teacherId,@PathVariable Integer courseId){
        courseService.assignCourseToTeacher(teacherId, courseId);
        return ResponseEntity.status(200).body("Course assigned to the specified teacher");
    }

    @GetMapping("get-teacher/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id){
       return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }

    @GetMapping("/get-students/{id}")
    public ResponseEntity getStudents(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getStudents(id));
    }
}
