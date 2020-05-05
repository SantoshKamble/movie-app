/**
 * 
 */
package com.santosh.moviesapp.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.santosh.moviesapp.models.Movie;

/**
 * @author santkamb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieDataLoaderServiceTest {
	
	@Mock
	private MovieService movieService;

	@InjectMocks
	private MovieDataLoaderService movieDataLoaderService;
	
	@Test
	public void loadMovieData() {
		List<Movie> movies = getMovies();		
		when(movieService.save(Mockito.anyListOf(Movie.class))).thenReturn(movies);
		assertDoesNotThrow(() -> movieDataLoaderService.loadMovieData("C:/Projects/movies-app/src/main/resources/movies.xml"));
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

