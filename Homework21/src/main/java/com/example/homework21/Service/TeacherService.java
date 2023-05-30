package com.example.homework21.Service;

import com.example.homework21.ApiException.ApiException;
import com.example.homework21.Model.Teacher;
import com.example.homework21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher t = teacherRepository.getTeacherById(id);
        if (t == null)
            throw new ApiException("Not found");
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());
        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id){
        Teacher t = teacherRepository.getTeacherById(id);
        if (t == null)
            throw new ApiException("Not found");
        teacherRepository.delete(t);
    }

    public Teacher getTeacher(Integer id){
        Teacher t = teacherRepository.getTeacherById(id);
        if (t == null)
            throw new ApiException("Not found");
        return t;
    }
}
