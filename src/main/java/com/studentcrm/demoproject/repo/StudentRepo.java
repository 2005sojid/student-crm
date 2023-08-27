package com.studentcrm.demoproject.repo;

import com.studentcrm.demoproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByIdIs(Long id);
}
