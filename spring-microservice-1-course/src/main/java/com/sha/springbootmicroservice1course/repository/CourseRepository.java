package com.sha.springbootmicroservice1course.repository;

import com.sha.springbootmicroservice1course.model.Course;


import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long>
{
    
}
