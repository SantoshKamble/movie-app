/**
 * 
 */
package com.santosh.moviesapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author santkamb
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException  {
	
	public CustomerNotFoundException(String exception) {
		super(exception);
	}

}
