package it.aulab.springthymeleaf.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "method not avaiable" )
public class AuthorNotFound extends RuntimeException{
    
}
