package com.finki.prodrive.prodrive.controllers;

import com.finki.prodrive.prodrive.model.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class TeacherController {

    /*
    Isto i ovde samo ovaj metod dodaj go vo postoeckata klasa
    * */

    @GetMapping("/teachers/{username}/students")
    public List<StudentDto> getTeachersAssignedStudents(@PathVariable String username) {
        return teacherRepository.getTeachersAssignedStudents(username);
    }
}
