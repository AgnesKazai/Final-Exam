package com.greenfox.errorhandlingwithexceptionhandler.controller;

import com.greenfox.errorhandlingwithexceptionhandler.model.ExceptionResponse;
import com.greenfox.errorhandlingwithexceptionhandler.exceptionhandling.ResourceNotFoundException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@ControllerAdvice
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ResponseBody
    public ExceptionResponse handleResourceNotFound(ResourceNotFoundException excep, HttpServletRequest req) {
        ExceptionResponse error = new ExceptionResponse();
        error.setRequestedURI(req.getRequestURI());
        error.setErrorMessage(excep.getMessage());
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
    public ExceptionResponse handleException(Exception excep, HttpServletRequest req) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(excep.getMessage());
        error.setRequestedURI(req.getRequestURI());
        return error;
    }

//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
////    @ResponseBody
//    public ExceptionResponse handleArrayIndexOutOfBounds(ArrayIndexOutOfBoundsException excep, HttpServletRequest req) {
//        ExceptionResponse error = new ExceptionResponse();
//        error.setErrorMessage(excep.getMessage());
//        error.setRequestedURI(req.getRequestURI());
//        return error;
//    }
}


