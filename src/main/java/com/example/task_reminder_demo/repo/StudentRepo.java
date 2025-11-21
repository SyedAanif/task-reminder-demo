package com.example.task_reminder_demo.repo;

import com.example.task_reminder_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// PAging And Sorting Repo
// CRUD  Repo
//@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findByRollNumber(Integer rollNumber);
}
//@Sql
//SELECT * FROM
//@Namedquer
////
