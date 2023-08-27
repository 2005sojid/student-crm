package com.studentcrm.demoproject.service;

import com.studentcrm.demoproject.entity.Course;
import com.studentcrm.demoproject.entity.Student;
import com.studentcrm.demoproject.repo.CourseRepo;
import com.studentcrm.demoproject.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    public Student getOne(Long id){
        return studentRepo.findStudentByIdIs(id);
    }

    public Student add(Student student){
        return studentRepo.save(student);
    }

    public void delete(Long id){
        studentRepo.deleteById(id);
    }

    public Student addCourseToStudent(Long stId, Long courseId){
        Student student = studentRepo.findById(stId).get();
        Set<Course> courses = student.getCourses();
        courses.add(courseRepo.findById(courseId).get());
        student.setCourses(courses);
        return studentRepo.save(student);
    }
}
