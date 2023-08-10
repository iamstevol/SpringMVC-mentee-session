package com.iamstevol.chad_darby_demo;

import com.iamstevol.chad_darby_demo.entity_mapping.Student;
import com.iamstevol.chad_darby_demo.entity_mapping.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ChadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChadApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            readStudent(studentDAO);
//            findAllStudent(studentDAO);
//            queryStudentByLastname(studentDAO);
//            updateStudent(studentDAO);
            deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int student = 3;
        studentDAO.delete(student);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student id = studentDAO.findById(2);
        id.setFirstName("Scooby");
        studentDAO.update(id);
        System.out.println(id.getFirstName());

    }

    private void queryStudentByLastname(StudentDAO studentDAO) {
        List<Student> name = studentDAO.findStudentsByLastName("Gomorrah");
        for(Student temp : name){
            System.out.println(temp);
        }
    }

    private void findAllStudent(StudentDAO studentDAO) {
        List<Student> allStudent = studentDAO.findAll();
        for(Student student : allStudent) {
            System.out.println(student);
        }

    }


    private void createStudent(StudentDAO studentDAO) {

        Student tempStudent = new Student("Adam", "Eve", "adam&eve@gmail.com");
        studentDAO.save(tempStudent);
        Integer theId = tempStudent.getId();
        System.out.println("Id of the saved student: " + theId);
    }

    private Student readStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Sodom", "Gomorrah", "sandg@gmail.com");
        studentDAO.save(tempStudent);
        Integer theId = tempStudent.getId();

        return studentDAO.findById(theId);
    }
}
