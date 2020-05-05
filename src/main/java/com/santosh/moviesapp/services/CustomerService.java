/**
 * 
 */
package com.santosh.moviesapp.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.santosh.moviesapp.models.Customer;
import com.santosh.moviesapp.repositories.CustomerRepository;

/**
 * @author santkamb
 *
 */
@Service
public class CustomerService {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	

	private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> list() {
        return customerRepository.findAll();
    }

    public Iterable<Customer> save(List<Customer> customers) {   	
    	Iterable<Customer> customerList =  customerRepository.saveAll(customers);
    	logger.info("customers are saved : {} ",customerList);
    	return customerList;
    }

	public Optional<Customer> retriveCustomer(Long customerId) {		
		 Optional<Customer> customer = customerRepository.findById(customerId);
		 logger.info("customer: {} ",customer);
		 return customer;
		
	}

}
