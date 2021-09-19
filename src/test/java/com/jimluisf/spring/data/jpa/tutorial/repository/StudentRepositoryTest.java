package com.jimluisf.spring.data.jpa.tutorial.repository;

import com.jimluisf.spring.data.jpa.tutorial.entity.Guardian;
import com.jimluisf.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.remote.rmi._RMIConnection_Stub;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //This will affect our database
//@DataJpaTest //This annotation will not
class StudentRepositoryTest
{
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("luis@gmail.com")
                .firstName("Luis")
                .lastName("Jimenez")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder()
                .name("Nick")
                .email("nick@gmail.com")
                .mobile("90923434343")
                .build();

        Student student = Student.builder()
                .emailId("james@gmail.com")
                .firstName("James")
                .lastName("Jimenez")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void dropStudentTable()
    {
        studentRepository.deleteAll();
    }

    @Test
    public void printAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
}