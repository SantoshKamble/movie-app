/**
 * 
 */
package com.santosh.moviesapp.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.moviesapp.persistence.models.MovieRecommendation;
import com.santosh.moviesapp.responses.MovieSuggestionResposne;
import com.santosh.moviesapp.services.MovieRecommendationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author santkamb
 *
 */

@RestController
@RequestMapping("api/movies-app")
@Api(value="Movie App", description="Operations pertaining to movie recommendation for given customer ")
public class MovieSuggestionController {
	
	private final Logger logger = LoggerFactory.getLogger(MovieSuggestionController.class);
	
	@Autowired
	private MovieRecommendationService movieRecommendationService;
	
	 @ApiOperation(value = "View a list of available movie recommendations for given customer ",response = Iterable.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "Successfully retrieved movie recommendations"),
	            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	    }
	    )
	@GetMapping(value="v1/movie/suggestion/customer/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieSuggestionResposne getMovieSuggestions(@PathVariable("id") long  customerId) {		
		logger.info("Getting movie Suggestions" );
		List<MovieRecommendation> movieRecommendations = movieRecommendationService.retrieveMovieRecommendation(customerId);
	//	List<MovieRecommendation> movieRecommendations = movieRecommendationService.getMovieRecommendation(customerId);
		MovieSuggestionResposne movieSuggestionResposne = new MovieSuggestionResposne();
		movieSuggestionResposne.setMovieRecommendations(movieRecommendations);
		logger.info("Getting movie Suggestions : {}", movieSuggestionResposne );
		return movieSuggestionResposne;
	}
	
	@GetMapping("v1/movie/suggesion/customer/hello-world/{id}")
	public String getMessge(@PathVariable long id) {
		return "Hello World"+id;
	}

}
