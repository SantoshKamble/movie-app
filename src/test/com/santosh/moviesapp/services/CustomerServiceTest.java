/**
 * 
 */
package com.santosh.moviesapp.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.santosh.moviesapp.persistence.models.Customer;
import com.santosh.moviesapp.persistence.models.Interest;
import com.santosh.moviesapp.persistence.repositories.CustomerRepository;

/**
 * @author santkamb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;
	
	@Test
	public void retrieveCustomerTest() {
		
		Optional<Customer> optCustomer = getCustomerOpt();
		when(customerRepository.findById(Mockito.anyLong())).thenReturn(optCustomer);
		Optional<Customer> cust = customerService.retrieveCustomer(1001l);
		Assert.assertTrue(cust.get().getName().equalsIgnoreCase("abc"));
	}

	@Test
	public void saveTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(getCustomer());
		when(customerRepository.saveAll(Mockito.anyIterableOf(Customer.class))).thenReturn(customers);
		Iterable<Customer> customerList  = customerService.save(customers);
		Assert.assertTrue(customerList!=null);
	}
	/**
	 * @return
	 */
	private Optional<Customer> getCustomerOpt() {
		Customer customer = getCustomer();
		Optional<Customer> optCustomer = Optional.of(customer);
		return optCustomer;
	}

	/**
	 * @return
	 */
	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(10001);
		customer.setName("abc");
		List<Interest> interests = new ArrayList<>();
		Interest interest = new Interest();
		interest.setActorName("xyz");
		interests.add(interest);
		customer.setInterests(interests );
		return customer;
	}

}
