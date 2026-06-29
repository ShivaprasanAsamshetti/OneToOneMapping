package com.springboot.associatemapping.service;

import com.springboot.associatemapping.dto.EmployeeDto;
import com.springboot.associatemapping.dto.EmployeePassportDto;
import com.springboot.associatemapping.entity.Employee;
import com.springboot.associatemapping.entity.EmployeePassport;
import com.springboot.associatemapping.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public EmployeeDto saveEmployee(EmployeeDto empDto) {

        Employee employee = new Employee();
        BeanUtils.copyProperties(empDto, employee);
        EmployeePassport passport = new EmployeePassport();
        BeanUtils.copyProperties(empDto.getPassport(), passport);

        employee.setEmployeePassport(passport); //two objects belongs together
        passport.setEmployee(employee);//two objects belongs together

//        Employee ←→ Passport
//        Both objects are linked.

        Employee employeeEntity = empRepo.save(employee);
        BeanUtils.copyProperties(employeeEntity, empDto);


        return empDto;
    }


    public EmployeeDto getEmployee(Integer id) {
        Employee employee = empRepo.findById(id).orElseThrow();
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        EmployeePassportDto employeePassportDto = new EmployeePassportDto();
        BeanUtils.copyProperties(employee.getEmployeePassport(), employeePassportDto);
        employeeDto.setPassport(employeePassportDto);

        return employeeDto;

    }
}


//for saveEmployee()
//Both objects are linked.
//
//Step 7
//Employee employeeEntity =
//        empRepo.save(employee);
//
//Question:
//
//You are saving only Employee.
//
//Why is Passport also saved?
//
//Because in the Employee entity you probably have:
//
//@OneToOne(cascade = CascadeType.ALL)
//private EmployeePassport employeePassport;
//
//Cascade means
//
//"When Employee is saved, automatically save Passport also."