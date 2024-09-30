package br.edu.iff.ccc.bsi.webdev.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiRestControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	ProblemDetail handlerDefaultException(Exception e) {
	
	ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(null, PAGE_NOT_FOUND_LOG_CATEGORY);
	
		return problemDetail;
	}
	
}
