package com.projects.vehicle.registration.repository;

import java.util.List; 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.vehicle.registration.model.Customer;

import jakarta.persistence.Tuple;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByEmail(String email);
	
	    
	@Query("SELECT c.id as id, c.firstName as firstName, c.lastName as lastName, " +
	       "c.email as email, c.phoneNumber as phoneNumber, COUNT(r.id) as registrations " +
	       "FROM Customer c LEFT JOIN Registration r ON c.id = r.customer.id " +
	       "GROUP BY c.id, c.firstName, c.lastName, c.email, c.phoneNumber")
	List<Tuple> findCustomerRegistrationStats();
}