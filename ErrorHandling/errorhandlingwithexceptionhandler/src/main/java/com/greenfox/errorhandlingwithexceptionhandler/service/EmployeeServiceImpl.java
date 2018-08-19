package com.greenfox.errorhandlingwithexceptionhandler.service;

import com.greenfox.errorhandlingwithexceptionhandler.exceptionhandling.EmployeeServiceException;
import com.greenfox.errorhandlingwithexceptionhandler.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee getEmployee() throws EmployeeServiceException {
        Employee emp = new Employee();
        emp.setName("Lars Johanson");
        emp.setDesignation("manager");
        emp.setSalary(300000);
        return emp;
    }

    @Override
    public Employee getEmployeeNull() throws EmployeeServiceException {
        return null;
    }

    @Override
    public Employee getEmployeeException() throws EmployeeServiceException {
        throw new EmployeeServiceException();
    }
}
