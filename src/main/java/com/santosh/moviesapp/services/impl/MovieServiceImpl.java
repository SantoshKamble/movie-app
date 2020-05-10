/**
 * 
 */
package com.santosh.moviesapp.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.persistence.dao.MovieDao;
import com.santosh.moviesapp.persistence.models.Movie;
import com.santosh.moviesapp.services.MovieService;

/**
 * @author santkamb
 *
 */
@Service
public class MovieServiceImpl implements MovieService {

	private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	private MovieDao movieDao;
		
    /**
	 * @param movieDao
	 */
	public MovieServiceImpl(MovieDao movieDao) {
		super();
		this.movieDao = movieDao;
	}

	@Override
	public Iterable<Movie> save(List<Movie> movies) {    	
    	Iterable<Movie> movieList =  movieDao.save(movies);
    	logger.info("Movies saved : {}",movieList);
    	return movieList;
    }

	@Override
	public List<Movie> retrieveMovies() {
		List<Movie> movies = (List<Movie>) movieDao.retrieveMovies();
		logger.info("Movies: {}  ", movies);
		return movies;
	}

	
	
	@Override
	public List<Movie> getMoviesBasedOnInterest(List<InterestDTO> interests ) {
		List<Movie> movies = movieDao.searchMovies(interests);
		return movies;
	}

	/*private static class MovieSearchSpecificaton {
		private static Specification<Movie> findByCriteria(List<InterestDTO> interests) {
			return new Specification<Movie>() {
				private static final long serialVersionUID = 1L;

				@Override
				public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> predicates = new ArrayList<>();
					
					for (InterestDTO interest : interests) {
						if (interest.getActorName() != null && !interest.getActorName().isEmpty()) {
							Join<Movie, Actor> actors = root.join("actors");
							predicates.add(cb.equal(actors.get("name"),interest.getActorName()));
						}
						if (null != interest.getGenres()) {
							Join<Movie, String> genres = root.join("generes");
		               	    predicates.add(genres.in(interest.getGenres()));
						}
						if (interest.getRatings() != 0.0d) {
							if(StringUtils.hasLength(interest.getRatingSymbol()) && interest.getRatingSymbol().equalsIgnoreCase("-")) {
								predicates.add(cb.lessThan(root.get("rating"), interest.getRatings()));
							}else if(StringUtils.hasLength(interest.getRatingSymbol()) && interest.getRatingSymbol().equalsIgnoreCase("+")) {
								predicates.add(cb.greaterThan(root.get("rating"), interest.getRatings()));
							}else {
								predicates.add(cb.equal(root.get("rating"), interest.getRatings()));
							}
						}
						if (interest.getRuntime() != 0) {
							if(StringUtils.hasLength(interest.getRuntimeSymbol()) && interest.getRuntimeSymbol().equalsIgnoreCase("<")) {
								predicates.add(cb.lessThan(root.get("runtime"), interest.getRuntime()));
							}else if(StringUtils.hasLength(interest.getRuntimeSymbol()) && interest.getRuntimeSymbol().equalsIgnoreCase(">")) {
								predicates.add(cb.greaterThan(root.get("runtime"), interest.getRuntime()));
							}else {
								predicates.add(cb.equal(root.get("runtime"), interest.getRuntime()));
							}
						}
					}
					return cb.and(predicates.toArray(new Predicate[predicates.size()]));
					
				}
			};
		}
	}*/
	
}
