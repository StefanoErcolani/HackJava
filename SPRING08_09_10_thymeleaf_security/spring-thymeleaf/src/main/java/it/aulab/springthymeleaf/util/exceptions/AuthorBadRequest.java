package it.aulab.springthymeleaf.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "What the fuck did you do?")
public class AuthorBadRequest extends RuntimeException{
    public AuthorBadRequest() {
        
    }
    public AuthorBadRequest(String message) {
        super(message);
    }

}
