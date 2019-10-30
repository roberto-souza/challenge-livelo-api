package livelo.challenge.api.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 8480478499003098156L;
	
	private final HttpStatus status;

	public ApiException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
        return this.status;
    }
	
}