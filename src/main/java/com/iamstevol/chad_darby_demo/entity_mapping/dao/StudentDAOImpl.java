package com.iamstevol.chad_darby_demo.entity_mapping.dao;

import com.iamstevol.chad_darby_demo.entity_mapping.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        try {
            TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
            return typedQuery.getResultList();
        }catch(Exception e) {
            System.out.println(e);
            throw new RuntimeException("No students available");
        }
    }

    @Override
    public List<Student> findStudentsByLastName(String theName) {
        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:theName", Student.class);
        query.setParameter("theName", theName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        Student student = entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

}
