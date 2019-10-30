package livelo.challenge.api.exceptions;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler({ ApiException.class })
	protected ResponseEntity<ErrorResponse> handleException(ApiException ex) {
		return new ResponseEntity<>(new ErrorResponse(ex.getStatus(), ex.getMessage(), Instant.now()), ex.getStatus());
	}

}
