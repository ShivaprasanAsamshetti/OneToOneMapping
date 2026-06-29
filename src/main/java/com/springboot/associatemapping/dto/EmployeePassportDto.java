package com.springboot.associatemapping.dto;

import lombok.Data;

@Data
public class EmployeePassportDto {
    private int passportId;
    private String passportName;
    private String issueDate;
    private String expiryDate;
}
