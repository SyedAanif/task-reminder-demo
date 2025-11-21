package com.example.task_reminder_demo.controller;

import com.example.task_reminder_demo.entity.Student;
import com.example.task_reminder_demo.models.StudentDto;
import com.example.task_reminder_demo.service.DummyService;
import com.example.task_reminder_demo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@RestController
@RequestMapping(path = "students")
public class StudentController {

    // OPENAPI, Swagger
    private StudentService studentService;
    private DummyService dummyService;

//    @Autowired
    public StudentController(StudentService studentService, DummyService dummyService) {
        this.studentService = studentService;
        this.dummyService = dummyService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        // debug
        dummyService.dummyMethod(1);
        // debug

//        throw new CustomException("Inside Controller Exception",new Exception("something"));
        return studentService.retrieveStudents();
    }

    @RequestMapping(method = {RequestMethod.POST})
//    @PostMapping
    public String createStudent(@RequestBody StudentDto studentDto) {
        studentService.registerStudent(studentDto);
        return "Created!!!";
    }

}

// Constructor Injection
// setter injection
// variable injection
// name
// type
