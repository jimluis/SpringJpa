package com.jimluisf.spring.data.jpa.tutorial.repository;

import com.jimluisf.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);//findBy+Class+attribute
    public Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL - queries are defined based on the java classes, not the native sql queries
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);
}
