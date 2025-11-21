package com.example.task_reminder_demo.service;

import com.example.task_reminder_demo.annotations.LogExecutionTime;
import com.example.task_reminder_demo.entity.Student;
import com.example.task_reminder_demo.models.StudentDto;
import com.example.task_reminder_demo.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

// weaving - proxies -aspects
// Reflection
@Service
public class StudentService {

//    @Autowired
    private StudentRepo studentRepo;


//    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> retrieveStudents() {

        // business logic


        //validations

        // query our database to retrieve the records
        return studentRepo.findAll();
    }

    public void registerStudent(StudentDto studentDto) {

        if (studentDto.getName() == "") {
            return;
        }

        studentRepo.findByRollNumber(20);
        studentRepo.save(new Student(studentDto.getName(), 300));
        // l1, l2 cache
    }
}
