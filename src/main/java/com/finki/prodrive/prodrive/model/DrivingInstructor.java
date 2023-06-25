package com.finki.prodrive.prodrive.model;

import lombok.Data;

import java.util.Date;

@Data
public class DrivingInstructor extends User {

    private String email;

    private Date employmentDate;

}
