package br.com.karen.userapi.resources.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.karen.userapi.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new StandardError(LocalDateTime.now(),
						ex.getMessage(), 
						HttpStatus.NOT_FOUND.value(),
						request.getRequestURI()));
	}
}
