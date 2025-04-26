package com.projects.vehicle.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.vehicle.registration.model.Registration;
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByCustomerId(Long customerId);
}