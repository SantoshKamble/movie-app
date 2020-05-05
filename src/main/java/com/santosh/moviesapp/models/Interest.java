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
public class Interest {
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO ) 
	private long id;
	//@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private String genres;
	//@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private String ratings;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	@JsonBackReference
	private Customer customer;
	//@Column
	//@Embedded
   // @ElementCollection(targetClass=Long.class)
	//@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@JsonProperty(value="actors")
	private String actorName;
	private String runtime;
	private String gender;
	
	
	
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
	 * @return the runtime
	 */
	public String getRuntime() {
		return runtime;
	}
	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public Interest() {
		
	}
	
	/**
	 * @return the actorName
	 */
	public String getActorName() {
		return actorName;
	}
	/**
	 * @param actorName the actorName to set
	 */
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the genres
	 */
	public String getGenres() {
		return genres;
	}
	/**
	 * @param genres the genres to set
	 */
	public void setGenres(String genres) {
		this.genres = genres;
	}
	/**
	 * @return the ratings
	 */
	public String getRatings() {
		return ratings;
	}
	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	/**
	 * @param id
	 * @param genres
	 * @param ratings
	 * @param customer
	 * @param actorName
	 * @param runtime
	 * @param gender
	 */
	public Interest(long id, String genres, String ratings, Customer customer, String actorName, String runtime,
			String gender) {
		super();
		this.id = id;
		this.genres = genres;
		this.ratings = ratings;
		this.customer = customer;
		this.actorName = actorName;
		this.runtime = runtime;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Interest [id=" + id + ", genres=" + genres + ", ratings=" + ratings + " actorName=" + actorName + ", runtime=" + runtime + ", gender=" + gender + "]";
	}
	
	
	
}
