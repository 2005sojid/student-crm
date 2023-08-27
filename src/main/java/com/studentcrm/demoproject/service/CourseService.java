package com.studentcrm.demoproject.service;

import com.studentcrm.demoproject.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final com.studentcrm.demoproject.repo.CourseRepo courseRepo;

    public CourseService(com.studentcrm.demoproject.repo.CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getCourses(){
        return courseRepo.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepo.findById(id).get();
    }

    public Course addCourse(Course course){
        return courseRepo.save(course);
    }


}
