package com.workerpartner.home.register.registerasemployee.entities;

import com.workerpartner.servicecategory.entity.ServiceCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_skill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSkill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id")
    private EmployeeEntities employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_category_id")
    private ServiceCategory serviceCategory;
    
    @Column(name = "service_name") 
    private String servicename;

    @Column(name = "hourly_rate")      private Integer hourlyRate;
    @Column(nullable = false)          private Boolean active = true;

    // getters and setters
}