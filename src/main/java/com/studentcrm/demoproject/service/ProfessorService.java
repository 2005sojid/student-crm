package com.studentcrm.demoproject.service;

import com.studentcrm.demoproject.entity.Course;
import com.studentcrm.demoproject.entity.Professor;
import com.studentcrm.demoproject.repo.CourseRepo;
import com.studentcrm.demoproject.repo.ProfessorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProfessorService {

    private final ProfessorRepo professorRepo;
    private final CourseRepo courseRepo;

    public ProfessorService(ProfessorRepo professorRepo, CourseRepo courseRepo) {
        this.professorRepo = professorRepo;
        this.courseRepo = courseRepo;
    }

    public List<Professor> getAll(){
        return professorRepo.findAll();
    }

    public Professor getOneById(Long id){
        return professorRepo.findById(id).get();
    }

    public Professor save(Professor professor){
        return professorRepo.save(professor);
    }

    public void delete(Professor professor){
        professorRepo.delete(professor);
    }

    public void deleteById(Long id){
        professorRepo.deleteById(id);
    }

    public Professor addCourseToProf(Long profId, Long courseId){
        Professor professor = professorRepo.findById(profId).get();
        Course course =  courseRepo.findById(courseId).get();
        Set<Course> courses = professor.getCourses();
        courses.add(course);
        professor.setCourses(courses);
        return professorRepo.save(professor);
    }
}
