package com.santosh.moviesapp.persistence.dao;

import java.util.List;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.persistence.models.Movie;

public interface MovieDao {

	Iterable<Movie> save(List<Movie> movies);

	List<Movie> retrieveMovies();

	List<Movie> searchMovies(List<InterestDTO> interests);

}