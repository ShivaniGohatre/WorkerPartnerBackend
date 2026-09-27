package com.workerpartner.home.register.verification.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "kyc_master_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KYCMasterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "aadhar_number", unique = true, length = 12)
    private String aadharNumber;

    @Column(name = "pan_number", unique = true, length = 10)
    private String panNumber;

    @Column(name = "dob")
    private Date dob;

 

}
