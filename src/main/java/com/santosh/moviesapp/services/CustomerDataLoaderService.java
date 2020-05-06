/**
 * 
 */
package com.santosh.moviesapp.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santosh.moviesapp.models.Customer;

/**
 * @author santkamb
 *
 */
@Component
public class CustomerDataLoaderService {

	private CustomerService customerService;
	
	private final Logger logger = LoggerFactory.getLogger(CustomerDataLoaderService.class);


	/**
	 * @param customerService
	 */
	public CustomerDataLoaderService(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	public void loadCustomerData(String filePath) {
		logger.info("Loading customer data from file {} ", filePath);
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
		};
		try {
			ClassPathResource resource = new ClassPathResource(filePath);
			InputStream inputStream = resource.getInputStream();
			//inputStream = new FileInputStream(new File(filePath));
			List<Customer> customers = mapper.readValue(inputStream, typeReference);
			customerService.save(customers);
			logger.info("Customers are Saved : {}", customers);
		} catch (FileNotFoundException e1) {
			logger.error("File not found", e1);
		} catch (IOException e) {
			logger.error("Unable to save users", e);
		}

	}

}
