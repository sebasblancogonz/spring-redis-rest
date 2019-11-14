package com.example.redis.controller;

import com.example.redis.dto.Student;
import com.example.redis.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value="/healthcheck", produces = "application/json;charset=utf-8")
    public String getHealthCheck() {
        return "{ \"isWorking\" : true }";
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Student> students() {
        return this.studentService.students();
    }

    @PostMapping(value = "/", produces = "application/json")
    public String saveStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @PostMapping(value = "/newStudents", produces = "application/json")
    public List<Student> saveStudents(@RequestBody List<Student> students) {
        return this.studentService.saveStudents(students);
    }

    @PostMapping(value = "/id", produces = "application/json")
    public Student student(@RequestBody Student student) {
        return this.studentService.student(student.getId()).orElse(null);
    }
}
