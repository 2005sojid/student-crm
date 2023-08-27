package com.studentcrm.demoproject.repo;

import com.studentcrm.demoproject.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor, Long> {
}
