package com.studentcrm.demoproject.rest;

import com.studentcrm.demoproject.entity.Professor;
import com.studentcrm.demoproject.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professors")
public class ProfessorRest {

    private final ProfessorService professorService;

    public ProfessorRest(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> allProfs(){
        return ResponseEntity.ok(professorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> oneProf(@PathVariable Long id){
        return ResponseEntity.ok(professorService.getOneById(id));
    }

    @PostMapping
    public ResponseEntity<Professor> addProf(@RequestBody Professor professor){
        return ResponseEntity.ok(professorService.save(professor));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProf(@RequestBody Professor professor){
        professorService.delete(professor);
        return ResponseEntity.ok("Professor was deleted");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfById(@PathVariable Long id){
        professorService.deleteById(id);
        return ResponseEntity.ok(String.format("Professor with id = %d was deleted", id));
    }

    @PutMapping("/{profId}/courses/{courseId}")
    public ResponseEntity<Professor> addCourseToProf(@PathVariable Long profId, @PathVariable Long courseId){
        return ResponseEntity.ok(professorService.addCourseToProf(profId, courseId));
    }
}
