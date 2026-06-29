package com.springboot.associatemapping.restcontroller;

import com.springboot.associatemapping.apiresponse.ApiResponse;
import com.springboot.associatemapping.dto.EmployeeDto;
import com.springboot.associatemapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employeeapi")
public class EmployeeRestApi {
    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<ApiResponse<EmployeeDto>> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1=employeeService.saveEmployee(employeeDto);
        ApiResponse<EmployeeDto> apiResponse=new ApiResponse<>();
        apiResponse.setData(employeeDto1);
        apiResponse.setStatus(201);
        apiResponse.setMessage("Employee saved successfully");

        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDto>> getEmployee(@PathVariable Integer id){
        EmployeeDto employeeDto=employeeService.getEmployee(id);
        ApiResponse<EmployeeDto> apiResponse=new ApiResponse<>();
        apiResponse.setMessage("Fetched employee with passport successfully");
        apiResponse.setData(employeeDto);
        apiResponse.setStatus(200);

        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

}
