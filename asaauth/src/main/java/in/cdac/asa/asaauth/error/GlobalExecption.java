package in.cdac.asa.asaauth.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExecption {

	@ExceptionHandler(ConstraintViolationException.class)
	public String constraintFailedHandler(ConstraintViolationException e) {
		return e.getMessage();
	}
}
