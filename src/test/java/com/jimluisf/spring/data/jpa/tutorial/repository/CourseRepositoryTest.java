package com.jimluisf.spring.data.jpa.tutorial.repository;

import com.jimluisf.spring.data.jpa.tutorial.entity.Course;
import com.jimluisf.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}