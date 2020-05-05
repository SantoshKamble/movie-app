/**
 * 
 */
package com.santosh.moviesapp.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.santosh.moviesapp.MoviesAppApplication;
import com.santosh.moviesapp.models.MovieRecommendation;
import com.santosh.moviesapp.responses.MovieSuggestionResposne;
import com.santosh.moviesapp.services.MovieRecommendationService;


/**
 * @author santkamb
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MoviesAppApplication.class)
@SpringBootTest
public class MovieSuggestionsControllerTest {

	private MockMvc mockMvc;

	@Mock
	private MovieRecommendationService movieRecommendationService;

	@InjectMocks
	private MovieSuggestionController movieSuggestionController;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void getMovieSuggestions_Integration() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/movies-app/v1/movie/suggestion/customer/id/1001")
				.accept(MediaType.APPLICATION_JSON))
				// .andExpect(jsonPath("$.movieRecommendations",hasSize(1))).andDo(print());
				.andExpect(jsonPath("$.movieRecommendations").exists());
	}

	@Test
	public void testGetMovieSuggestions() {
		List<MovieRecommendation> movieRecommendations = getMovies();
		when(movieRecommendationService.rectrieveMovieRecommendation(Mockito.anyLong()))
				.thenReturn(movieRecommendations);
		MovieSuggestionResposne movieSuggestionResposne = movieSuggestionController.getMovieSuggestions(1001);
		Assert.assertTrue(movieSuggestionResposne.getMovieRecommendations().size() == 1);
	}

	/**
	 * @return
	 */
	private List<MovieRecommendation> getMovies() {
		List<MovieRecommendation> movieRecommendations = new ArrayList<>();
		MovieRecommendation movie = new MovieRecommendation();
		movie.setTitle("abc");
		movie.setImdb("http://example.org/abc");
		movieRecommendations.add(movie);
		return movieRecommendations;
	}
}
