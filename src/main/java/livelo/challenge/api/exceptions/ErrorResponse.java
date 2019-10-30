package livelo.challenge.api.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private final HttpStatus status;
    private final String message;
    private final Instant timestamp;

    public ErrorResponse(HttpStatus status, String message, Instant timestamp) {
        this.status= status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() { 
        return this.status; 
    }

    public String getMessage() {
        return this.message;
    }

    public Instant getTimestamp() {
    	return this.timestamp;
    }

}
