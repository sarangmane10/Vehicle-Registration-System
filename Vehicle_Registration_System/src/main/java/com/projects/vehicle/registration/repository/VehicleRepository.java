package com.projects.vehicle.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.vehicle.registration.model.Vehicle;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
//    Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
//    boolean existsByVehicleNumber(String vehicleNumber);
	@Query(nativeQuery = true,value = "select color from vehicle_colors where vehicle_id=?1")
	List<String> FindColorsById(Long id);
}
