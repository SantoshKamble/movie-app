/**
 * 
 */
package com.santosh.moviesapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.santosh.moviesapp.persistence.dao.CustomerDao;
import com.santosh.moviesapp.persistence.models.Customer;
import com.santosh.moviesapp.services.CustomerService;

/**
 * @author santkamb
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	private CustomerDao customerDao;

   
    /**
	 * @param customerDao
	 */
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public Iterable<Customer> retrieveAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
	public Iterable<Customer> save(List<Customer> customers) {   	
    	Iterable<Customer> customerList =  customerDao.save(customers);
    	logger.info("customers are saved : {} ",customerList);
    	return customerList;
    }

	@Override
	public Optional<Customer> retrieveCustomer(Long customerId) {		
		 Optional<Customer> customer = customerDao.getCustomer(customerId);
		 logger.info("customer: {} ",customer);
		 return customer;
		
	}

}
