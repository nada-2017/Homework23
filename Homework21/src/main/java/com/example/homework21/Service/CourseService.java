package com.example.homework21.Service;

import com.example.homework21.ApiException.ApiException;
import com.example.homework21.Model.Course;
import com.example.homework21.Model.Student;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.CourseRepository;
import com.example.homework21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course c = courseRepository.getCourseById(id);
        if (c == null)
            throw new ApiException("Not found");
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void deleteCourse(Integer id){
        Course c = courseRepository.getCourseById(id);
        if (c == null)
            throw new ApiException("Not found");
        courseRepository.delete(c);
    }

    public void assignCourseToTeacher(Integer teacherId, Integer courseId){
        Teacher t = teacherRepository.getTeacherById(teacherId);
        Course c = courseRepository.getCourseById(courseId);
        if (t == null || c == null)
            throw new ApiException("Invalid");
        c.setTeacher(t);
        courseRepository.save(c);
    }

    public String getTeacherName(Integer id){
        Teacher t = courseRepository.getCourseById(id).getTeacher();
        return t.getName();
    }

    public Set<Student> getStudents(Integer id){
        Course c = courseRepository.getCourseById(id);
        if (c == null)
            throw new ApiException("Not found");
        return c.getStudentSet();
    }
}
