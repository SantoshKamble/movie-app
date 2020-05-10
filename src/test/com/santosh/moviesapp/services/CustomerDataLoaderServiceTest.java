/**
 * 
 */
package com.santosh.moviesapp.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.santosh.moviesapp.persistence.models.Customer;
import com.santosh.moviesapp.persistence.models.Interest;

/**
 * @author santkamb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDataLoaderServiceTest {

	@InjectMocks
	private CustomerDataLoaderService customerDataLoaderService;
	
	@Mock
	private CustomerService customerService;
	
	@Test
	public void loadCustomerData() {		
		List<Customer> customers = new ArrayList<>();
		customers.add(getCustomer());
		when(customerService.save(Mockito.anyListOf(Customer.class))).thenReturn(customers);
		assertDoesNotThrow(() -> customerDataLoaderService.loadCustomerData("C:/Projects/movies-app/src/main/resources/profiles.json"));
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
