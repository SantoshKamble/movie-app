package com.santosh.moviesapp.services;

import java.util.List;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.persistence.models.Movie;

public interface MovieService {

	Iterable<Movie> save(List<Movie> movies);

	List<Movie> retrieveMovies();

	List<Movie> getMoviesBasedOnInterest(List<InterestDTO> interests);

}