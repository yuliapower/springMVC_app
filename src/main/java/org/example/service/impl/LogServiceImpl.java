package org.example.service.impl;

import org.example.dao.LogDAO;
import org.example.entity.Log;
import org.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    
    private final LogDAO logDAO;
    
    @Autowired
    public LogServiceImpl(LogDAO logDAO) {
        this.logDAO = logDAO;
    }
    
    @Override
    public void add(Log log) {
        log.setOffsetDateTime(OffsetDateTime.now());
        if (log.getMessage() == null) log.setMessage("EMPTY log");
        if (log.getMessage() == null) log.setStudentId(null);
        logDAO.add(log);
    }
    
    @Override
    public List<Log> logsByStudent(Long studentId) {
        List<Log> logs = logDAO.findAll();
        List<Log> result = new ArrayList<>();
        for (Log l : logs) {
            if (l.getStudentId()!= null && l.getStudentId().equals(studentId))
                result.add(l);
        }
        System.out.println(result); // TODO
        return result;
    }
    
    @Override
    public void update(Log log) {
        Log logResult = logDAO.get(log);
        if (logResult != null) {
            if (log.getStudentId() != null) logResult.setStudentId(log.getStudentId());
            if (log.getOffsetDateTime() != null) logResult.setOffsetDateTime(log.getOffsetDateTime());
            if (log.getMessage() != null) logResult.setMessage(log.getMessage());
            logDAO.add(logResult);
        }
    }
}
