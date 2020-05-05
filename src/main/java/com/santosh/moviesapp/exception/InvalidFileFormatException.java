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
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidFileFormatException extends RuntimeException {

	public InvalidFileFormatException(String exception) {
		super(exception);
	}
}
