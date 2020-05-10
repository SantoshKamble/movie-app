/**
 * 
 */
package com.santosh.moviesapp.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.santosh.moviesapp.persistence.models.Movie;
import com.santosh.moviesapp.persistence.repositories.MovieRespository;

/**
 * @author santkamb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieServiceTest {
	
	@Mock
	private MovieRespository movieRespository ;
	
	@InjectMocks
	private MovieService movieService;
	
	@Test
	public void retrieveMoviesTest() {
		List<Movie> movies = getMovies();
		when(movieRespository.findAll()).thenReturn(movies);
		List<Movie> movieList = movieService.retrieveMovies();
		Assert.assertTrue(movieList.size()==1);
	}
	
	@Test
	public void saveTest() {
		List<Movie> movies = getMovies();		
		when(movieRespository.saveAll(Mockito.anyIterableOf(Movie.class))).thenReturn(movies);
		Iterable<Movie> movieList  = movieService.save(movies);
		Assert.assertTrue(movieList!=null);
	}

	private List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<>();		
		Movie movie = new Movie();
		List<String> generes = new ArrayList<>();
		generes.add("Action");
		movie.setGeneres(generes );
		movie.setTitle("XYZ");
		movie.setRating(8d);
		movies.add(movie);
		return movies;
	}

}
