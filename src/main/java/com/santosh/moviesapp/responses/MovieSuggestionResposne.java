/**
 * 
 */
package com.santosh.moviesapp.responses;

import java.util.ArrayList;
import java.util.List;

import com.santosh.moviesapp.persistence.models.MovieRecommendation;

/**
 * @author santkamb
 *
 */
public class MovieSuggestionResposne {
	
	@Override
	public String toString() {
		return "MovieSuggestionResposne [movieRecommendations=" + movieRecommendations + "]";
	}

	List<MovieRecommendation> movieRecommendations = new ArrayList<>();

	/**
	 * @return the movieRecommendations
	 */
	public List<MovieRecommendation> getMovieRecommendations() {
		return movieRecommendations;
	}

	/**
	 * @param movieRecommendations the movieRecommendations to set
	 */
	public void setMovieRecommendations(List<MovieRecommendation> movieRecommendations) {
		this.movieRecommendations = movieRecommendations;
	}

	/**
	 * @param movieRecommendations
	 */
	public MovieSuggestionResposne(List<MovieRecommendation> movieRecommendations) {
		super();
		this.movieRecommendations = movieRecommendations;
	}
	
	public MovieSuggestionResposne() {
		
	}

}
