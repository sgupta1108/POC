package com.springboot.mindtree.exception;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class); 

	@ExceptionHandler({ Exception.class, RuntimeException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleCustomException(HttpServletRequest request,
			Exception ex) {
		LOG.info("GlobalExceptionHandler HttpServletRequest request :" + request);
		LOG.error("Error Track is:::---", ex);
		ex.printStackTrace();
		LOG.error(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Global Exception");
	}
}
