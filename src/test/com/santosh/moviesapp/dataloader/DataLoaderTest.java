/**
 * 
 */
package com.santosh.moviesapp.dataloader;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.santosh.moviesapp.configuration.FileType;
import com.santosh.moviesapp.configuration.Folder;
import com.santosh.moviesapp.configuration.MovieConfig;
import com.santosh.moviesapp.services.impl.CustomerDataLoaderServiceImpl;
import com.santosh.moviesapp.services.impl.MovieDataLoaderServiceImpl;

/**
 * @author santkamb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DataLoaderTest {
	
	@Mock
	private CustomerDataLoaderServiceImpl customerDataLoader;
	
	@Mock
	private MovieDataLoaderServiceImpl movieDataLoader;
	
	@Mock
	private MovieConfig config;
	
	@Mock
	private MessageSource messageSource;
	
	@InjectMocks
	private DataLoader dataLoader;
	
	@Mock
	private Folder folder ;
	
	@Mock
	private FileType fileType;

	
	@Test
	public void runTest() {		
		when(config.getFolder()).thenReturn(folder);
		when(folder.getCustomer()).thenReturn("C:/Projects/movies-app/src/main/resources/profiles.json");
		when(folder.getMovie()).thenReturn("C:/Projects/movies-app/src/main/resources/movies.xml");
		when(config.getFileType()).thenReturn(fileType);
		when(fileType.getJson()).thenReturn("json");
		when(fileType.getXml()).thenReturn("xml");
		Mockito.doNothing().when(customerDataLoader).loadCustomerData(Mockito.anyString());
		Mockito.doNothing().when(movieDataLoader).loadMovieData(Mockito.anyString());
		assertDoesNotThrow(() -> dataLoader.run("C:/Projects/movies-app/src/main/resources/movies.xml"));
	}

}
