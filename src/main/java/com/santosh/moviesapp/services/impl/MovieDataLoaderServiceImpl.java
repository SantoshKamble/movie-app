/**
 * 
 */
package com.santosh.moviesapp.services.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.santosh.moviesapp.persistence.models.Movie;
import com.santosh.moviesapp.services.MovieDataLoaderService;
import com.santosh.moviesapp.services.MovieService;

/**
 * @author santkamb
 *
 */
@Component
public class MovieDataLoaderServiceImpl implements MovieDataLoaderService {

	private MovieService movieService;
	
	private final Logger logger = LoggerFactory.getLogger(MovieDataLoaderServiceImpl.class);


	/**
	 * @param movieService
	 */
	public MovieDataLoaderServiceImpl(MovieService movieService) {
		this.movieService = movieService;
	}

	@Override
	public void loadMovieData(String filePath) {
		logger.info("Loading Movie data from file ",filePath);
		//File file = new File(filePath);
		XmlMapper xmlMapper = new XmlMapper();
		String xml;
		try {
			ClassPathResource resource = new ClassPathResource(filePath);
			xml = inputStreamToString(resource.getInputStream());
			TypeReference<List<Movie>> typeReference1 = new TypeReference<List<Movie>>() {
			};
			List<Movie> movies = xmlMapper.readValue(xml, typeReference1);
			movieService.save(movies);
			logger.info("Movies are saved {} ",movies);
		}catch (FileNotFoundException e1) {
			logger.error("File not found",e1);
		}  catch (IOException e) {
			logger.error("Data Load Exception occured",e);
		}

	}

	@Override
	public String inputStreamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
}
