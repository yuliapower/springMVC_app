package org.example.service;

import org.example.entity.Log;

import java.util.List;

public interface LogService {
    
    void add(Log log);
    
    List<Log> logsByStudent(Long studentId);
    
    void update(Log id);
}
