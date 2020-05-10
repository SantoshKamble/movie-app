/**
 * 
 */
package com.santosh.moviesapp.services.impl;

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
import org.springframework.util.StringUtils;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.exception.CustomerNotFoundException;
import com.santosh.moviesapp.exception.MovieRecommendationsNotFoundException;
import com.santosh.moviesapp.persistence.models.Actor;
import com.santosh.moviesapp.persistence.models.Customer;
import com.santosh.moviesapp.persistence.models.Interest;
import com.santosh.moviesapp.persistence.models.Movie;
import com.santosh.moviesapp.persistence.models.MovieRecommendation;
import com.santosh.moviesapp.services.CustomerService;
import com.santosh.moviesapp.services.MovieRecommendationService;
import com.santosh.moviesapp.services.MovieService;
import com.santosh.moviesapp.util.MoviesUtil;




/**
 * @author santkamb
 *
 */
@Service
public class MovieRecommendationServiceImpl implements MovieRecommendationService {
	
	private final Logger logger = LoggerFactory.getLogger(MovieRecommendationServiceImpl.class);
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public List<MovieRecommendation> retrieveMovieRecommendation(Long customerId) {

		List<MovieRecommendation> movieRecommendations = new ArrayList<>();
		List<Movie> movieListFinal = new ArrayList<>();

		Optional<Customer> OptCustomer = customerService.retrieveCustomer(customerId);

		if (!OptCustomer.isPresent()) {
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
			if (null != movie && StringUtils.hasLength(movie.getTitle()) && StringUtils.hasLength(movie.getImdb())) {
				MovieRecommendation movieRecommendation = new MovieRecommendation();
				movieRecommendation.setTitle(movie.getTitle());
				movieRecommendation.setImdb(movie.getImdb());
				movieRecommendations.add(movieRecommendation);
			}});
		logger.info("Movie recommendations",movieRecommendations);
		if(null==movieRecommendations ||  movieRecommendations.isEmpty()) {
			throw new MovieRecommendationsNotFoundException(
					messageSource.getMessage("movie.not.found", null, LocaleContextHolder.getLocale()));
		}
		return movieRecommendations;
	}

	@Override
	public List<MovieRecommendation> getMovieRecommendation(Long customerId) {
		List<MovieRecommendation> movieRecommendations = new ArrayList<>();
		List<Movie> movies = new ArrayList<>();

		Optional<Customer> OptCustomer = customerService.retrieveCustomer(customerId);

		if (!OptCustomer.isPresent()) {
			throw new CustomerNotFoundException(
					messageSource.getMessage("customer.not.found", null, LocaleContextHolder.getLocale()));
		} else {
			Customer customer = OptCustomer.get();
			if (!customer.getInterests().isEmpty() && customer.getInterests() != null) {
				List<InterestDTO> interests = convertToInterestDTO(customer.getInterests());
				movies = movieService.getMoviesBasedOnInterest(interests);
			}
		}

		movies.forEach(movie -> {
			if (null != movie && StringUtils.hasLength(movie.getTitle()) && StringUtils.hasLength(movie.getImdb())) {
				MovieRecommendation movieRecommendation = new MovieRecommendation();
				movieRecommendation.setTitle(movie.getTitle());
				movieRecommendation.setImdb(movie.getImdb());
				movieRecommendations.add(movieRecommendation);
			}
		});
		logger.info("Movie recommendations", movieRecommendations);
		if(null==movieRecommendations || movieRecommendations.isEmpty()) {
			throw new MovieRecommendationsNotFoundException(
					messageSource.getMessage("movie.not.found", null, LocaleContextHolder.getLocale()));
		}
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
			|| (Objects.nonNull(movie.getRating()) && Objects.nonNull(interest.getRatings()) && filterMovies(interest.getRatings(),movie.getRating()))
			|| (Objects.nonNull(movie.getRuntime()) && Objects.nonNull(interest.getRuntime()) && filterMovies(interest.getRuntime(),(double)movie.getRuntime()))
		).collect(Collectors.toList());
		
	}
		
	@Override
	public List<InterestDTO> convertToInterestDTO(List<Interest> interests) {
		List<InterestDTO> interestDTOs = new ArrayList<InterestDTO>();
		for (Interest interest : interests) {
			InterestDTO interestDTO = new InterestDTO();
			interestDTO.setActorName(interest.getActorName());
			interestDTO.setGender(interest.getGender());
			interestDTO.setGenres(interest.getGenres());
			String rating = MoviesUtil.getNumberFromString(interest.getRatings());
			String ratingSymbol = MoviesUtil.getSymbolFromString(interest.getRatings());
			String runtime = MoviesUtil.getNumberFromString(interest.getRuntime());
			String runtimeSymbol = MoviesUtil.getSymbolFromString(interest.getRuntime());
			if (StringUtils.hasLength(ratingSymbol))
				interestDTO.setRatingSymbol(ratingSymbol);
			if (StringUtils.hasLength(runtimeSymbol))
				interestDTO.setRuntimeSymbol(runtimeSymbol);
			if (StringUtils.hasLength(rating)) {
				interestDTO.setRatings(Double.valueOf(rating));
			}
			if (StringUtils.hasLength(runtime)) {
				interestDTO.setRuntime(Long.valueOf(runtime));
			}
			interestDTOs.add(interestDTO);
		}
		return interestDTOs;
	}
	
	private static boolean filterMovies(String interestRating, Double movieRating) {
		String symbol = MoviesUtil.getSymbolFromString(interestRating);
		String number = MoviesUtil.getNumberFromString(interestRating);
		if (StringUtils.hasLength(symbol) && StringUtils.hasLength(number)) {
			switch (symbol) {
			case "<":
				if (Double.valueOf(number) > movieRating)
					return true;
				break;
			case ">":
				if (Double.valueOf(number) < movieRating)
					return true;
				break;
			case "+":
				if (Double.valueOf(number) < movieRating)
					return true;
				break;
			case "-":
				if (Double.valueOf(number) > movieRating)
					return true;
				break;
			}
		}
		return false;

	}
	
		
}
