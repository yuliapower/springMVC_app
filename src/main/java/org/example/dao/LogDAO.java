package org.example.dao;

import org.example.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDAO {
    
    void add(Log log);
    
    public List<Log> findAll();
    
    Log get(Log log);
    
    void remove(Long studentId);
}
