package com.finki.prodrive.prodrive.controllers;

import com.finki.prodrive.prodrive.model.DrivingInstructor;
import com.finki.prodrive.prodrive.model.StudentDto;
import com.finki.prodrive.prodrive.repository.DrivingInstructorJdbcRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrivingInstructorController {

    private final DrivingInstructorJdbcRepository drivingInstructorJdbcRepository = new DrivingInstructorJdbcRepository();

    @GetMapping("/instructors")
    public List<DrivingInstructor> getDrivingInstructors() {
        return drivingInstructorJdbcRepository.getAllDrivingInstructors();
    }

    @GetMapping("/students/exams/{username}")
    public List<StudentDto> getInstructorsAssignedInstructors(@PathVariable String username) {
        return drivingInstructorJdbcRepository.getInstructorsAssignedInstructors(username);
    }
}
