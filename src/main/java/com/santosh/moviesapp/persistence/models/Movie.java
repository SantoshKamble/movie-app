/**
 * 
 */
package com.santosh.moviesapp.persistence.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author santkamb
 *
 */
@Entity
public class Movie {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO ) 
	private long id;
	private String title ;
	
	@JacksonXmlElementWrapper( localName = "actors" )
	@JacksonXmlProperty( localName = "actor" )
	@OneToMany(mappedBy="movie" ,cascade =CascadeType.ALL )
	@JsonManagedReference
	private List<Actor> actors = new ArrayList<Actor>();
	@JacksonXmlElementWrapper( localName = "genres" )
	@JacksonXmlProperty( localName = "genere" )
	@ElementCollection(targetClass=String.class)
	private List<String> generes;
	private double rating;
	private long runtime;
	private String imdb;

	


	
	/**
	 * @return the imdb
	 */
	public String getImdb() {
		return imdb;
	}


	/**
	 * @param imdb the imdb to set
	 */
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}


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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the actors
	 */
	public List<Actor> getActors() {
		return actors;
	}


	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}


	/**
	 * @param id
	 * @param title
	 * @param actors
	 * @param generes
	 * @param rating
	 * @param runtime
	 * @param imdb
	 */
	public Movie(long id, String title, List<Actor> actors, List<String> generes, double rating, long runtime,
			String imdb) {
		super();
		this.id = id;
		this.title = title;
		this.actors = actors;
		this.generes = generes;
		this.rating = rating;
		this.runtime = runtime;
		this.imdb = imdb;
	}


	/**
	 * @return the generes
	 */
	public List<String> getGeneres() {
		return generes;
	}


	/**
	 * @param generes the generes to set
	 */
	public void setGeneres(List<String> generes) {
		this.generes = generes;
	}


	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}


	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}


	/**
	 * @return the runtime
	 */
	public long getRuntime() {
		return runtime;
	}


	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}


	public Movie() {
		
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", actors=" + actors + ", generes=" + generes + ", rating="
				+ rating + ", runtime=" + runtime + ", imdb=" + imdb + "]";
	}
	
	
}
