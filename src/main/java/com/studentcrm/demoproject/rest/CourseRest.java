package com.studentcrm.demoproject.rest;

import com.studentcrm.demoproject.entity.Course;
import com.studentcrm.demoproject.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseRest {

    private final CourseService courseService;

    public CourseRest(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> courses(){
        return ResponseEntity.ok(courseService.getCourses());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> course(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseService.addCourse(course));
    }
}
