package com.example.demo.controller;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exception.StudentNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(
            value = HttpStatus.BAD_GATEWAY,
            reason = "Requested Student Not Found")
    @ExceptionHandler(StudentNotFoundException.class)
    public void handleException(StudentNotFoundException e) {
		  /*
		   * 如果自定義的類有標註@ResponseStatus則讓他自己處理
		   */
		  if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			  //再將例外拋出
			  throw e;
		  }
		  
    }
}
