package com.sha.springbootmicroservice1course.service;

import com.sha.springbootmicroservice1course.model.Course;

import java.util.List;


public interface CourseService
{
    Course saveCourse(Course course);

    void deleteCourse(Long courseId);

    List<Course> findAllCourses();
}
