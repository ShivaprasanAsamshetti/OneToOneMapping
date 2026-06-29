package com.springboot.associatemapping.dto;

import com.springboot.associatemapping.entity.EmployeePassport;
import lombok.Data;

import java.util.List;

@Data
public class

EmployeeDto {
    private int employeeId;
    private String employeName;
    private String gender;
    private long mobileNumber;
    private EmployeePassportDto passport;

}
