/**
 * 
 */
package com.santosh.moviesapp.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.santosh.moviesapp.persistence.models.Customer;
import com.santosh.moviesapp.persistence.models.Interest;
import com.santosh.moviesapp.persistence.models.Movie;
import com.santosh.moviesapp.persistence.models.MovieRecommendation;


/**
 * @author santkamb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovieRecommendationServiceTest {
	
	@Mock
	private CustomerService customerService;
	
	@Mock
	private MovieService movieService;

	@InjectMocks
	private MovieRecommendationService movieRecommendationService;
	
	@Test
	public void rectrieveMovieRecommendationTest() {		
		when(customerService.retrieveCustomer(Mockito.anyLong())).thenReturn(getCustomerOpt());
		when(movieService.retrieveMovies()).thenReturn(getMovies());		
		List<MovieRecommendation>	recommendationList = movieRecommendationService.retrieveMovieRecommendation(1001l);
		Assert.assertTrue(recommendationList.size()==1);
	}
	

	/**
	 * @return
	 */
	private Optional<Customer> getCustomerOpt() {
		Customer customer = getCustomer();
		Optional<Customer> optCustomer = Optional.of(customer);
		return optCustomer;
	}

	/**
	 * @return
	 */
	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(10001);
		customer.setName("abc");
		List<Interest> interests = new ArrayList<>();
		Interest interest = new Interest();
		interest.setGenres("Action");
		interests.add(interest);
		customer.setInterests(interests );
		return customer;
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
