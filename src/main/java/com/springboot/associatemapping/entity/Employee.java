package com.springboot.associatemapping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeName;
    private String gender;
    private long mobileNumber;      

    @OneToOne(mappedBy ="employee", cascade=CascadeType.ALL)
    private EmployeePassport EmployeePassport;


}
