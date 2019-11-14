package com.example.redis.service;

import com.example.redis.dto.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    String saveStudent(Student student);

    List<Student> saveStudents(List<Student> students);

    List<Student> students();

    Optional<Student> student(String id);
}
