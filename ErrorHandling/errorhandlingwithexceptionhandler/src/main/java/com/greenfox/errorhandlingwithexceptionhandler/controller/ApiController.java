package com.greenfox.errorhandlingwithexceptionhandler.controller;

import com.greenfox.errorhandlingwithexceptionhandler.exceptionhandling.EmployeeServiceException;
import com.greenfox.errorhandlingwithexceptionhandler.exceptionhandling.ResourceNotFoundException;
import com.greenfox.errorhandlingwithexceptionhandler.model.Employee;
import com.greenfox.errorhandlingwithexceptionhandler.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final EmployeeService employeeService;

    @Autowired
    public ApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //En employee is returned
    @GetMapping("/employee")
    public Employee getEmpl() throws ResourceNotFoundException, EmployeeServiceException {
        try {
            Employee emp = employeeService.getEmployee();
            if (emp == null) {
                throw new ResourceNotFoundException("Employee not found");
            }
            return emp;
        } catch (EmployeeServiceException e) {
            throw new EmployeeServiceException("Internal Server Exception while getting exception");
        }
    }

    //no employee found so ResourceNotFoundException is thrown
    @GetMapping("/employee2")
    public Employee getEmp2() throws ResourceNotFoundException, EmployeeServiceException {
        try {
            Employee emp = employeeService.getEmployeeNull();
            if (emp == null) {
                throw new ResourceNotFoundException("Employee not found");
            }
            return emp;
        } catch (EmployeeServiceException e) {
            throw new EmployeeServiceException("Internal Server Exception while getting exception");
        }
    }

    //Some exception is thrown by service layer
    @GetMapping("/employee3")
    public Employee getEmp3() throws ResourceNotFoundException, EmployeeServiceException {
        try {
            Employee emp = employeeService.getEmployeeException();
            if (emp == null) {
                throw new ResourceNotFoundException("Employee not found");
            }
            return emp;
        } catch (Exception e) {
            throw new EmployeeServiceException("Internal Server Exception while getting exception");
        }
    }
//    @GetMapping("/array")
//    public Integer getThirdElementFromArray() throws ArrayIndexOutOfBoundsException {
//        try {
//            int a[] = new int[2];
//            return a[5];
//        } catch (Exception e) {
//           throw new ArrayIndexOutOfBoundsException("There is no more element!");
//        }
//    }
}

