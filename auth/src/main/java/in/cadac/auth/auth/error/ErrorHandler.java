package in.cadac.auth.auth.error;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class ErrorHandler {
	private  Logger logger=LoggerFactory.getLogger(ErrorHandler.class);
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error -> 
	            errors.put(error.getField(), error.getDefaultMessage())
	        );
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
//	   @ExceptionHandler(MethodArgumentNotValidException.class)
//	    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
//	        Map<String, String> errors = new HashMap<>();
//	        ex.getBindingResult().getFieldErrors().forEach(error -> 
//	            errors.put(error.getField(), error.getDefaultMessage())
//	        );
//	        errors.forEach((key,value)->{
//	        	logger.info(key+":"+value);
//	        });
//	        return new ResponseEntity<String>("AUTH_XML_INVALID", HttpStatus.BAD_REQUEST);
//	    }
}
