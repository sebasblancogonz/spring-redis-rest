package com.example.redis.service.impl;

import com.example.redis.dto.Student;
import com.example.redis.repository.StudentRepository;
import com.example.redis.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {
        studentRepository.save(student);
        return "{ \"" + student.getName() + "\" : \"saved\" }";
    }

    @Override
    public List<Student> saveStudents(List<Student> students) {
        return (List<Student>) this.studentRepository.saveAll(students);
    }

    @Override
    public List<Student> students() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Optional<Student> student(String id) {
        return this.studentRepository.findById(id);
    }
}
