/**
 * 
 */
package com.santosh.moviesapp.models;

/**
 * @author santkamb
 *
 */
public class MovieRecommendation {

	private String title;
	private String imdb;
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
	 * @param title
	 * @param imdb
	 */
	public MovieRecommendation(String title, String imdb) {
		super();
		this.title = title;
		this.imdb = imdb;
	}
	
	public MovieRecommendation(){
		
	}
	@Override
	public String toString() {
		return "MovieRecommendation [title=" + title + ", imdb=" + imdb + "]";
	}
	
	
}
