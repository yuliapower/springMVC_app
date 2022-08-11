package org.example.dao.impl;


import org.example.dao.StudentDAO;
import org.example.entity.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    
    private final SessionFactory sessionFactory;
    
    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void save(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }
    
    @Override
    public void deleteById(Long id) {
        Student student = sessionFactory.getCurrentSession().get(Student.class, id);
        if (student != null) {
            sessionFactory.getCurrentSession().delete(student);
        }
    }
    
    @Override
    public List<Student> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a FROM Student a", Student.class).list();
    }
}
