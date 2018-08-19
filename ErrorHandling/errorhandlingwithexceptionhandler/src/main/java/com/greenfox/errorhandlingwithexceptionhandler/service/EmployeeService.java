package com.greenfox.errorhandlingwithexceptionhandler.service;

import com.greenfox.errorhandlingwithexceptionhandler.exceptionhandling.EmployeeServiceException;
import com.greenfox.errorhandlingwithexceptionhandler.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    public Employee getEmployee() throws EmployeeServiceException;

    public Employee getEmployeeNull() throws EmployeeServiceException;

    public Employee getEmployeeException() throws EmployeeServiceException;
}
