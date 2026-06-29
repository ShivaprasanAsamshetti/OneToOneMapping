package com.springboot.associatemapping.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EmployeePassport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;
    private String passportName;
    private String issueDate;
    private String expiryDate;

    @OneToOne
    @JoinColumn(name="employeeId")
    private Employee employee;
}
