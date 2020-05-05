/**
 * 
 */
package com.santosh.moviesapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.santosh.moviesapp.exception.CustomerNotFoundException;
import com.santosh.moviesapp.models.Actor;
import com.santosh.moviesapp.models.Customer;
import com.santosh.moviesapp.models.Interest;
import com.santosh.moviesapp.models.Movie;
import com.santosh.moviesapp.models.MovieRecommendation;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author santkamb
 *
 */
@Service
public class MovieRecommendationService {
	
	private final Logger logger = LoggerFactory.getLogger(MovieRecommendationService.class);
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MessageSource messageSource;

	public List<MovieRecommendation> rectrieveMovieRecommendation(Long customerId) {

		List<MovieRecommendation> movieRecommendations = new ArrayList<>();
		List<Movie> movieListFinal = new ArrayList<>();

		Optional<Customer> OptCustomer = customerService.retriveCustomer(customerId);

		if (!OptCustomer.isPresent()) {
			//System.out.println("message "+ messageSource.getMessage("customer.not.found", null,LocaleContextHolder.getLocale()));
		//	throw new CustomerNotFoundException("customer id : " + customerId);
			
			throw new CustomerNotFoundException(messageSource
			.getMessage("customer.not.found" , null,
					LocaleContextHolder.getLocale()));
		} else {
			Customer customer = OptCustomer.get();
			List<Movie> movies = movieService.retrieveMovies();

			if (!customer.getInterests().isEmpty() && customer.getInterests() != null) {
				customer.getInterests().forEach(interest -> {
					List<Movie> movieList = filterMoviesBasedOnInterest(movies, interest);
					movieListFinal.addAll(movieList);

				});
			}
		}

		movieListFinal.forEach(movie -> {
			if (null != movie && StringUtils.isNotBlank(movie.getTitle()) && StringUtils.isNotBlank(movie.getImdb())) {
				MovieRecommendation movieRecommendation = new MovieRecommendation();
				movieRecommendation.setTitle(movie.getTitle());
				movieRecommendation.setImdb(movie.getImdb());
				movieRecommendations.add(movieRecommendation);
			}});
		logger.info("Movie recommendations",movieRecommendations);
		return movieRecommendations;
	}

	private boolean getMovieBasedOnActorOrGender(Movie movie, String gender, String actorName) {

		if (null != movie && (null != gender || null != actorName)) {
			for (Actor actor : movie.getActors()) {
				if (null != actor && ((null != actor.getName() && actor.getName().equalsIgnoreCase(actorName))
						|| (null != actor.getGender() && actor.getGender().equalsIgnoreCase(gender)))) {
					return true;
				}

			}
		}

		return false;
	}

	private List<Movie> filterMoviesBasedOnInterest(List<Movie> movies, Interest interest) {
		return movies.stream()
		.filter(movie -> Objects.nonNull(movie)	&& Objects.nonNull(interest) &&
			   getMovieBasedOnActorOrGender(movie,interest.getGender(),interest.getActorName())
			|| (Objects.nonNull(movie.getGeneres()) && Objects.nonNull(interest.getGenres()) && movie.getGeneres().contains(interest.getGenres()))
			|| (Objects.nonNull(movie.getRating()) && Objects.nonNull(interest.getRatings()) && String.valueOf(movie.getRating()).equals(interest.getRatings()))
			|| (Objects.nonNull(movie.getRuntime()) && Objects.nonNull(interest.getRuntime()) && (String.valueOf(movie.getRuntime()).equals(interest.getRuntime())))
		).collect(Collectors.toList());
		
	}
	
}
