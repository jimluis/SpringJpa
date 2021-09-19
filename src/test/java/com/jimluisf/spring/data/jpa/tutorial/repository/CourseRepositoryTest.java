package com.jimluisf.spring.data.jpa.tutorial.repository;

import com.jimluisf.spring.data.jpa.tutorial.entity.Course;
import com.jimluisf.spring.data.jpa.tutorial.entity.Student;
import com.jimluisf.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest
{
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourses()
    {
       List<Course> coursesList = courseRepository.findAll();
        System.out.println("coursesList = " + coursesList);
    }

    @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Jane")
                .lastName("Doe")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination()
    {
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);



        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllWithSorting()
    {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
//        System.out.println("sortByTitleAndCreditDesc = " + sortByTitleAndCreditDesc);
//        System.out.println("sortByCreditDesc = " + sortByCreditDesc);
//        System.out.println("sortByTitle = " + sortByTitle);
    }

    @Test
    public void findByTitleContaining()
    {
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent() ;
        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher()
    {
        Teacher teacher = Teacher.builder()
                .firstName("Sheldon")
                .lastName("Cooper")
                .build();

        Student student = Student.builder()
                .firstName("Missy")
                .lastName("Cooper")
                .emailId("missy@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}