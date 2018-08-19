package com.greenfox.errorhandlingwithexceptionhandler.exceptionhandling;

public class EmployeeServiceException extends Exception{

    public EmployeeServiceException() {
        super();
    }

    public EmployeeServiceException(final String message) {
        super(message);
    }
}
