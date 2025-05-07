package com.projects.vehicle.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projects.vehicle.registration.model.Registration;

import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByCustomerId(Long customerId);
    
    @Query(nativeQuery = true, value="select r.id,c.first_name,c.last_name,v.brand,v.model,year_of_manufacture,c.email,r.registration_date,r.status"
    		+ " from registration r join vehicle v on v.id=r.vehicle_id\r\n"
    		+ "join customer c on r.customer_id = c.id")
    List<Tuple> getRegistrationDetails();
    
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="update registration set status=?2 where id=?1")
    int approveAction(Long id,String message);
}