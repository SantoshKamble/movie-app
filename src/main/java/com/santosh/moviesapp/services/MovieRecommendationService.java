package com.santosh.moviesapp.services;

import java.util.List;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.persistence.models.Interest;
import com.santosh.moviesapp.persistence.models.MovieRecommendation;

public interface MovieRecommendationService {

	List<MovieRecommendation> retrieveMovieRecommendation(Long customerId);

	List<MovieRecommendation> getMovieRecommendation(Long customerId);

	List<InterestDTO> convertToInterestDTO(List<Interest> interests);

}