package com.example.homework21.Service;

import com.example.homework21.ApiException.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Repository.CourseRepository;
import com.example.homework21.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student s = studentRepository.getStudentsById(id);
        if (s == null)
            throw new ApiException("Not found");
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id){
        Student s = studentRepository.getStudentsById(id);
        if (s == null)
            throw new ApiException("Not found");
        studentRepository.delete(s);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId){
        Student s = studentRepository.getStudentsById(studentId);
        Course c = courseRepository.getCourseById(courseId);
        if (s == null || c == null)
            throw new ApiException("Invalid");
        s.getCourseSet().add(c);
        c.getStudentSet().add(s);
        studentRepository.save(s);
        courseRepository.save(c);
    }

    public void changeMajor(Integer id, String major){
        Student s = studentRepository.getStudentsById(id);
        if (s == null)
            throw new ApiException("Not found");
        s.setMajor(major);
        s.getCourseSet().clear();
        studentRepository.save(s);
    }
}
