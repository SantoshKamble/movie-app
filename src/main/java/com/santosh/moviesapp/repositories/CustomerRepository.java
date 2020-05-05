/**
 * 
 */
package com.santosh.moviesapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santosh.moviesapp.models.Customer;

/**
 * @author santkamb
 *
 */
@Repository
public interface  CustomerRepository extends JpaRepository<Customer,Long> {

	
}
