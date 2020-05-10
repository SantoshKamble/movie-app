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
public class MovieRecommendationsNotFoundException extends RuntimeException  {
		
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public MovieRecommendationsNotFoundException(String exception) {
			super(exception);
		}
}
