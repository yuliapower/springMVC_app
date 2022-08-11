package org.example.dao;

import org.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {
    
    void save(Student student);
    
    void deleteById(Long id);
    
    List<Student> findAll();
    
}
