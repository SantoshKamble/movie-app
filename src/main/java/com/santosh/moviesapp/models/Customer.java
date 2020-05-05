/**
 * 
 */
package com.santosh.moviesapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author santkamb
 *
 */
@Entity
public class Customer {
	
	@Id
 //   @GeneratedValue( strategy = GenerationType.AUTO ) 
	@JsonProperty(value="customer_id")
	private long customerId;
	private String name;
	
   // @ElementCollection(targetClass=Interest.class)
	@OneToMany(mappedBy="customer" ,cascade =CascadeType.ALL )	
	@JsonManagedReference
	List<Interest> interests = new ArrayList<Interest>();
	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
	 * @return the interests
	 */
	public List<Interest> getInterests() {
		return interests;
	}
	/**
	 * @param interests the interests to set
	 */
	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}
	/**
	 * @param customerId
	 * @param name
	 * @param interests
	 */
	public Customer(long customerId, String name, List<Interest> interests) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.interests = interests;
	}
	
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", interests=" + interests + "]";
	}
	
}
