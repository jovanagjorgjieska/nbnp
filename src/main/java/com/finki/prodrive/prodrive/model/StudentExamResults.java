package com.finki.prodrive.prodrive.model;

import lombok.Data;

import java.util.Date;

@Data
public class StudentExamResults {

    private String studentUsername;

    private int examId;

    private int attemptNumber;

    private int points;

    private String type;

    private Date examDate;

}