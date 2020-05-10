/**
 * 
 */
package com.santosh.moviesapp.persistence.dao.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.santosh.moviesapp.persistence.dao.CustomerDao;
import com.santosh.moviesapp.persistence.models.Customer;
import com.santosh.moviesapp.persistence.repositories.CustomerRepository;
import com.santosh.moviesapp.services.impl.CustomerServiceImpl;

/**
 * @author santkamb
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	private CustomerRepository customerRepository;

	/**
	 * @param customerRepository
	 */
	public CustomerDaoImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Iterable<Customer> save(List<Customer> customers) {
		Iterable<Customer> customerList = customerRepository.saveAll(customers);
		logger.info("customers are saved : {} ", customerList);
		return customerList;
	}

	@Override
	public Optional<Customer> getCustomer(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		logger.info("customer: {} ", customer);
		return customer;

	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
