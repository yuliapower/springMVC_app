package org.example.controller;


import org.example.entity.Log;
import org.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class LogController {
    
    private final LogService logService;
    
    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }
    
    @PostMapping
    public void add(@RequestBody Log log) {
        logService.add(log);
    }
    
    @GetMapping("/{studentId}")
    public List<Log> findAll(@PathVariable Long studentId) {

        return logService.logsByStudent(studentId);
    }
    
    @PatchMapping
    public void updateLog(@RequestBody Log log) {
        logService.update(log);
    }
}
