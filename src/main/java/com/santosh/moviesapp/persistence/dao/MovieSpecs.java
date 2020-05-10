/**
 * 
 */
package com.santosh.moviesapp.persistence.dao;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.santosh.moviesapp.persistence.models.Movie;

/**
 * @author santkamb
 *
 */
public class MovieSpecs {

	
	 public static Specification<Movie> getMovieByGenresSpec(String genres) {
	      return (root, query, criteriaBuilder) -> {
	    	  Expression<String> parentExpression = root.get("generes");
	          Predicate equalPredicate = parentExpression.in(root.get("generes"), genres);
	          return equalPredicate;
	      };
	  }

	/*  public static Specification<Movie> getEmployeesByPhoneTypeSpec(Str phoneType) {
	      return (root, query, criteriaBuilder) -> {
	      //    ListJoin<Movie, Actor> actorJoin = root.join("actors").get("actor");
	          Predicate equalPredicate = criteriaBuilder.in(actorJoin.get("generes"), phoneType);
	          query.distinct(true);
	          return equalPredicate;
	      };
	  }*/

	/*  public static Specification<Employee> getEmployeesByNameOrPhoneTypeSpec(String name,
	                                                                          PhoneType phoneType) {
	      return Specification.where(getEmployeesByNameSpec(name))
	                          .or(getEmployeesByPhoneTypeSpec(phoneType));
	  }

	  public static Specification<Employee> getEmployeesByNameAndPhoneTypeSpec(String name,
	                                                                           PhoneType phoneType) {
	      return Specification.where(getEmployeesByNameSpec(name))
	                          .and(getEmployeesByPhoneTypeSpec(phoneType));
	  }

	  public static Specification<Employee> getEmployeeByNotNameSpec(String name) {
	      return Specification.not(getEmployeesByNameSpec(name));
	  }
	}*/
}
