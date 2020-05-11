/**
 * 
 */
package com.santosh.moviesapp.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.santosh.moviesapp.dtos.InterestDTO;
import com.santosh.moviesapp.persistence.dao.MovieSearchSpecification;
import com.santosh.moviesapp.persistence.models.Actor;
import com.santosh.moviesapp.persistence.models.Movie;

/**
 * @author santkamb
 *
 */
public class MovieSearchSpecificatonImpl implements MovieSearchSpecification  {
	
	@Override
	public  Specification<Movie> findByCriteria(List<InterestDTO> interests) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				
				for (InterestDTO interest : interests) {
					if (interest.getActorName() != null && !interest.getActorName().isEmpty()) {
						Join<Movie, Actor> actors = root.join("actors");
						predicates.add(cb.equal(actors.get("name"),interest.getActorName()));
					}
					if (interest.getActorName() != null && !interest.getGender().isEmpty()) {
						Join<Movie, Actor> actors = root.join("actors");
						predicates.add(cb.equal(actors.get("gender"),interest.getGender()));
					}
					if (null != interest.getGenres()) {
						Join<Movie, String> genres = root.join("generes");
	               	    predicates.add(genres.in(interest.getGenres()));
					}
					if (interest.getRatings() != 0.0d) {
						if(StringUtils.hasLength(interest.getRatingSymbol()) && interest.getRatingSymbol().equalsIgnoreCase("-")) {
							predicates.add(cb.lessThan(root.get("rating"), interest.getRatings()));
						}else if(StringUtils.hasLength(interest.getRatingSymbol()) && interest.getRatingSymbol().equalsIgnoreCase("+")) {
							predicates.add(cb.greaterThan(root.get("rating"), interest.getRatings()));
						}else {
							predicates.add(cb.equal(root.get("rating"), interest.getRatings()));
						}
					}
					if (interest.getRuntime() != 0) {
						if(StringUtils.hasLength(interest.getRuntimeSymbol()) && interest.getRuntimeSymbol().equalsIgnoreCase("<")) {
							predicates.add(cb.lessThan(root.get("runtime"), interest.getRuntime()));
						}else if(StringUtils.hasLength(interest.getRuntimeSymbol()) && interest.getRuntimeSymbol().equalsIgnoreCase(">")) {
							predicates.add(cb.greaterThan(root.get("runtime"), interest.getRuntime()));
						}else {
							predicates.add(cb.equal(root.get("runtime"), interest.getRuntime()));
						}
					}
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
				
			}
		};
	}


}
