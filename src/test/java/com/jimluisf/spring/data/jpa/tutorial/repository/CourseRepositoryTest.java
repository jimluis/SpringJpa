package com.jimluisf.spring.data.jpa.tutorial.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest
{
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void savingCourse()
    {

    }

}