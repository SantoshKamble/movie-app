/**
 * 
 */
package com.santosh.moviesapp.dataloader;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.santosh.moviesapp.configuration.MovieConfig;
import com.santosh.moviesapp.exception.InvalidFileFormatException;
import com.santosh.moviesapp.services.CustomerDataLoaderService;
import com.santosh.moviesapp.services.MovieDataLoaderService;

/**
 * @author santkamb
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	
	@Autowired
	private CustomerDataLoaderService customerDataLoader;
	
	@Autowired
	private MovieDataLoaderService movieDataLoader;
	
	@Autowired
	private MovieConfig config;
	
	@Autowired
	private MessageSource messageSource;
	
	public DataLoader() {
		
	}

	
	/**
	 * @param customerDataLoader
	 * @param movieDataLoader
	 * @param config
	 * @param messageSource
	 */
	public DataLoader(CustomerDataLoaderService customerDataLoader, MovieDataLoaderService movieDataLoader,
			MovieConfig config, MessageSource messageSource) {
		super();
		this.customerDataLoader = customerDataLoader;
		this.movieDataLoader = movieDataLoader;
		this.config = config;
		this.messageSource = messageSource;
	}


	@Override
	public void run(String... strings)  {
		logger.info("Loading data...");
		System.out.println("######" + config.getFolder().getCustomer());
		System.out.println("######" + config.getFolder().getMovie());
		System.out.println("######" + config.getFileType().getJson());
		System.out.println("######" + config.getFileType().getXml());
		


		String customerFilePathString = config.getFolder().getCustomer();
		String movieFilePathString = config.getFolder().getMovie();
		
		if(null!=customerFilePathString && validateFileType(config.getFileType().getJson(), customerFilePathString) ) {
			customerDataLoader.loadCustomerData(customerFilePathString);
		}
		
		if(null!=movieFilePathString && validateFileType(config.getFileType().getXml(), movieFilePathString) ) {
			movieDataLoader.loadMovieData(movieFilePathString);
		}
		
	}		
	
	private Optional<String> getExtensionOfFile(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}

	private  boolean validateFileType(String requiredFileType, String filePathString) {
		Optional<String> fileExtensionOpt = getExtensionOfFile(filePathString);
		if (fileExtensionOpt.isPresent() && fileExtensionOpt.get().equalsIgnoreCase(requiredFileType)) {
			return true;
		}
		else {
		//	throw new InvalidFileFormatException("Required File format is "+requiredFileType+ "and recived file format" +filePathString );
			
			throw new InvalidFileFormatException(messageSource
			.getMessage("file.format.message" , null,
					LocaleContextHolder.getLocale()));
		}
	}
	

	

}
