/**
 * 
 */
package com.santosh.moviesapp.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.santosh.moviesapp.persistence.models.Customer;

/**
 * @author santkamb
 *
 */

public interface  CustomerRepository extends JpaRepository<Customer,Long> ,JpaSpecificationExecutor<Customer>  {

	
}
