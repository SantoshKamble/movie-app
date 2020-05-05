/**
 * 
 */
package com.santosh.moviesapp.models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author santkamb
 *
 */
@Entity
@Embeddable
public class Actor {
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO ) 
	private long id;
	private String name;
	private String gender;
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	@JsonProperty(value="actors")
	@JsonBackReference
	private Movie movie;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param gender
	 * @param movie
	 */
	public Actor(long id, String name, String gender, Movie movie) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.movie = movie;
	}
	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Actor() {
		
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", gender=" + gender +  "]";
	}

}
