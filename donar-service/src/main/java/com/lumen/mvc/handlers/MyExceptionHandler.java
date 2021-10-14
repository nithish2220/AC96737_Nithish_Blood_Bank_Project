package com.lumen.mvc.handlers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.lumen.mvc.handlers.ErrorHandler;

@RestControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ErrorHandler handleAllExceptions(Exception ex, WebRequest req) {
		return new ErrorHandler(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
	}
	
}
