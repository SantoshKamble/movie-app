/**
 * 
 */
package com.santosh.moviesapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.santosh.moviesapp.models.Movie;
import com.santosh.moviesapp.repositories.MovieRespository;

/**
 * @author santkamb
 *
 */
@Service
public class MovieService {

	private final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	private MovieRespository movieRespository ;

    /**
	 * @param movieRespository
	 */
	public MovieService(MovieRespository movieRespository) {
		super();
		this.movieRespository = movieRespository;
	}

    public Iterable<Movie> save(List<Movie> movies) {    	
    	Iterable<Movie> movieList =  movieRespository.saveAll(movies);
    	logger.info("Movies saved : {}",movieList);
    	return movieList;
    }

	public List<Movie> retrieveMovies() {
		List<Movie> movies = movieRespository.findAll();
		logger.info("Movies: {}  ", movies);
		return movies;
	}
}
