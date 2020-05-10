/**
 * 
 */
package com.santosh.moviesapp.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.santosh.moviesapp.persistence.models.Movie;

/**
 * @author santkamb
 *
 */
public interface MovieRecommendationRepository extends CrudRepository<Movie, Long>,
QueryByExampleExecutor<Movie> {
}
