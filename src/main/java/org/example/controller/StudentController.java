package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping(value = "/students")
    public void add(@RequestBody Student student) {
        studentService.save(student);
    }
    
    @DeleteMapping(value = "/students/{studentId}")
    public void deleteById(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
