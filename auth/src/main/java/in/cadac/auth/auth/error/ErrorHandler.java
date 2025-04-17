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

import feign.RetryableException;

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
//	   RetryableException e
	   
	   @ExceptionHandler(RetryableException.class)
	   public ResponseEntity<ErrorDto> handleRetryException(RetryableException ex) {
	       ErrorDto error = new ErrorDto(ex.getMessage(), "503");
	       return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
	   }
	   @ExceptionHandler(DuplicateKeyException.class)
	   public ResponseEntity<ErrorDto> handleRetryException(DuplicateKeyException ex) {
	       ErrorDto error = new ErrorDto("Duplicate Transaction ID", "AUA-AUTH-11");
	       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	   }
	   @ExceptionHandler(CryptoException.class)
	   public ResponseEntity<ErrorDto> handleCryptoException(CryptoException ex) {
	       ErrorDto error = new ErrorDto(ex.getMessage(), "AUA-AUTH-09");
	       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	   }
	   @ExceptionHandler(LKNotFoundException.class)
	   public ResponseEntity<ErrorDto> handleLKNotFoundException(LKNotFoundException ex) {
		   ErrorDto error = new ErrorDto(ex.getMessage(), "AUA-C-11");
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	   }

	   public ResponseEntity<ErrorDto> handleExpiredClientLkException(ExpiredClientLkException ex) {
		   ErrorDto error = new ErrorDto(ex.getMessage(), "AUA-AUTH-15");
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
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
