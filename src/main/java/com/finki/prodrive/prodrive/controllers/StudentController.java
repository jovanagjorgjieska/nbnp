package com.finki.prodrive.prodrive.controllers;

import com.finki.prodrive.prodrive.model.Student;
import com.finki.prodrive.prodrive.model.StudentExamResults;
import com.finki.prodrive.prodrive.repository.StudentJdbcRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentJdbcRepository studentRepository = new StudentJdbcRepository();

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/students/exams/{username}")
    public List<StudentExamResults> getStudentExamsResults(@PathVariable String username) {
        return studentRepository.getResultsByUsername(username);
    }
}
