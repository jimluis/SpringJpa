package com.jimluisf.spring.data.jpa.tutorial.repository;

import com.jimluisf.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
