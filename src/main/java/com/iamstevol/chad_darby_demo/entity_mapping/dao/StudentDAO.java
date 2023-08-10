package com.iamstevol.chad_darby_demo.entity_mapping.dao;

import com.iamstevol.chad_darby_demo.entity_mapping.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findStudentsByLastName(String theName);

    void update(Student theStudent);

    void delete(Integer id);
}
