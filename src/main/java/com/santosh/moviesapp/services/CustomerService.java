package com.santosh.moviesapp.services;

import java.util.List;
import java.util.Optional;

import com.santosh.moviesapp.persistence.models.Customer;

public interface CustomerService {


	Iterable<Customer> save(List<Customer> customers);

	Optional<Customer> retrieveCustomer(Long customerId);

	Iterable<Customer> retrieveAllCustomers();

}