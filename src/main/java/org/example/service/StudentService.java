package org.example.service;

import org.example.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    
    void deleteById(Long id);
    
    List<Student> findAll();
}
