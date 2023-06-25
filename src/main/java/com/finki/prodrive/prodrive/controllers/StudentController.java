package com.finki.prodrive.prodrive.controllers;

import com.finki.prodrive.prodrive.model.*;
import com.finki.prodrive.prodrive.repository.StudentJdbcRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/students/lecture")
    public void addStudentAttendanceToLecture(@RequestBody LectureAttendance lectureAttendance) {
        studentRepository.addStudentAttendanceToLecture(lectureAttendance.getLectureId(),
                lectureAttendance.getStudentUsername(), lectureAttendance.getLectureDate());
    }

    @PostMapping("/students/exams")
    public void addStudentAttendanceToExam(@RequestBody ExamAttendance examAttendance) {
        studentRepository.addStudentAttendanceToExam(examAttendance.getExamId(),
                examAttendance.getStudentUsername(), examAttendance.getAttemptNumber());
    }

    @GetMapping("/students/total")
    public Integer getTotalStudents() {
        return studentRepository.getTotalStudents();
    }

    @GetMapping("/students/average/{username}")
    public Double getAverageExamScore(@PathVariable String username) {
        return studentRepository.calculateAverageExamScore(username);
    }

    @GetMapping("/students/lecture/{lectureId}")
    public List<StudentDto> getAttendingStudents(@PathVariable int lectureId) {
        return studentRepository.getAttendingStudents(lectureId);
    }

    @GetMapping("/students/exams/passed/{examId}")
    public List<StudentDto> getPassedStudents(@PathVariable int examId) {
        return studentRepository.getPassedStudents(examId);
    }

}
