package com.santosh.moviesapp.persistence.dao;

import java.util.List;
import java.util.Optional;

import com.santosh.moviesapp.persistence.models.Customer;

public interface CustomerDao {

	Iterable<Customer> save(List<Customer> customers);

	Optional<Customer> getCustomer(Long customerId);

	Iterable<Customer> getAllCustomers();

}