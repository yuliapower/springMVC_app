package org.example.service.impl;

import org.example.dao.LogDAO;
import org.example.dao.StudentDAO;
import org.example.entity.Log;
import org.example.entity.Student;
import org.example.service.LogService;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final LogDAO logDAO;
    private final LogService logService;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, LogDAO logDAO, LogService logService) {
        this.studentDAO = studentDAO;
        this.logDAO = logDAO;
        this.logService = logService;
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
        Log log = new Log();
        List<Log> logs = logDAO.findAll();
        log.setStudentId(student.getId());
        log.setOffsetDateTime(OffsetDateTime.now());
        log.setMessage("SAVE student with id " + student.getId() + " data/time:" + log.getOffsetDateTime());
        logDAO.add(log);
    }

    @Override
    @Transactional
    public void deleteById(Long studentId) {
        List<Log> logs = logDAO.findAll();
        for (Log l : logs)
            if (l.getStudentId() != null && l.getStudentId().equals(studentId)) {
                Log log = new Log();
                log.setMessage("DELETE student with id " + studentId);
                log.setStudentId(studentId);
                logService.add(log);
            }
        studentDAO.deleteById(studentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
}
