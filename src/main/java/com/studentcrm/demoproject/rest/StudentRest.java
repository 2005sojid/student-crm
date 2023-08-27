package com.studentcrm.demoproject.rest;

import com.studentcrm.demoproject.entity.Student;
import com.studentcrm.demoproject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRest {
    private final StudentService studentService;


    public StudentRest(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getOne(id));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> add(@RequestBody Student student){
        return ResponseEntity.ok(studentService.add(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok("Student was deleted");
    }

    @PutMapping("/students/{stId}/courses/{courseId}")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable Long stId, @PathVariable Long courseId){
       return ResponseEntity.ok(studentService.addCourseToStudent(stId, courseId));
    }
}
