/**
 * 
 */
package com.santosh.moviesapp.dtos;

/**
 * @author santkamb
 *
 */
public class InterestDTO {
	
	private String genres;
	private String gender;
	private String actorName;
	private double ratings;
	private long runtime;
	private String ratingSymbol;
	private String runtimeSymbol;
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
	 * @return the ratings
	 */
	public double getRatings() {
		return ratings;
	}
	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(double ratings) {
		this.ratings = ratings;
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
	
	
	/**
	 * @return the ratingSymbol
	 */
	public String getRatingSymbol() {
		return ratingSymbol;
	}
	/**
	 * @param ratingSymbol the ratingSymbol to set
	 */
	public void setRatingSymbol(String ratingSymbol) {
		this.ratingSymbol = ratingSymbol;
	}
	/**
	 * @return the runtimeSymbol
	 */
	public String getRuntimeSymbol() {
		return runtimeSymbol;
	}
	/**
	 * @param runtimeSymbol the runtimeSymbol to set
	 */
	public void setRuntimeSymbol(String runtimeSymbol) {
		this.runtimeSymbol = runtimeSymbol;
	}
	
	/**
	 * @param genres
	 * @param gender
	 * @param actorName
	 * @param ratings
	 * @param runtime
	 * @param ratingSymbol
	 * @param runtimeSymbol
	 */
	public InterestDTO(String genres, String gender, String actorName, double ratings, long runtime,
			String ratingSymbol, String runtimeSymbol) {
		super();
		this.genres = genres;
		this.gender = gender;
		this.actorName = actorName;
		this.ratings = ratings;
		this.runtime = runtime;
		this.ratingSymbol = ratingSymbol;
		this.runtimeSymbol = runtimeSymbol;
	}
	public InterestDTO() {
		
	}
	

}
