/**
 * 
 */
package com.santosh.moviesapp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.santosh.moviesapp.persistence.models.Movie;

/**
 * @author santkamb
 *
 */

public interface MovieRespository extends CrudRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

}
