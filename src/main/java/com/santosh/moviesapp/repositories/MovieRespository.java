/**
 * 
 */
package com.santosh.moviesapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santosh.moviesapp.models.Movie;

/**
 * @author santkamb
 *
 */
@Repository
public interface MovieRespository extends JpaRepository<Movie,Long> {

}
