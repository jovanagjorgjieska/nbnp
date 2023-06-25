package com.finki.prodrive.prodrive.model;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class LectureAttendance {

    private Integer lectureId;
    private String studentUsername;
    private Timestamp lectureDate;
}
