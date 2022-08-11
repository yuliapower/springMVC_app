package org.example.dao.impl;

import org.example.dao.LogDAO;
import org.example.entity.Log;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDAOImpl implements LogDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public LogDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Log log) {
        sessionFactory.getCurrentSession().save(log);
    }

    @Override
    public List<Log> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a FROM Log a", Log.class).list();
    }

    @Override
    public Log get(Log log) {
        return sessionFactory.getCurrentSession().get(Log.class, log.getId());
    }

    @Override
    public void remove(Long studentId) {
        Log log = sessionFactory.getCurrentSession().get(Log.class, studentId);
        if (log != null) {
            sessionFactory.getCurrentSession().delete(log);
        }
    }
}
