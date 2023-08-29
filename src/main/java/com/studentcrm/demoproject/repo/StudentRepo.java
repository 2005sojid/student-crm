package com.studentcrm.demoproject.repo;

import com.studentcrm.demoproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByIdIs(Long id);

    Set<Student> findStudentsByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
    Set<Student> findStudentsByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrCourses_NameContainingIgnoreCase(String name, String email, String courseName);
}
