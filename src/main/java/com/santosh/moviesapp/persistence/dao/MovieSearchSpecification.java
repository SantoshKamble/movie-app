package com.santosh.moviesapp.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.persistence.models.Movie;

public interface MovieSearchSpecification {

	Specification<Movie> findByCriteria(List<InterestDTO> interests);

}