package com.projects.vehicle.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.vehicle.registration.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}