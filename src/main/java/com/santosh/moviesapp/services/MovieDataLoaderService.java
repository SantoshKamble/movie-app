package com.santosh.moviesapp.services;

import java.io.IOException;
import java.io.InputStream;

public interface MovieDataLoaderService {

	void loadMovieData(String filePath);

	String inputStreamToString(InputStream is) throws IOException;

}