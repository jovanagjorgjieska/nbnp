package com.finki.prodrive.prodrive.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
public class Student extends User {

    @Column(name = "first_aid_certificate")
    private boolean firstAidCertificate;

    @Column(name = "drivers_licence")
    private boolean hasDriversLicence;
}
