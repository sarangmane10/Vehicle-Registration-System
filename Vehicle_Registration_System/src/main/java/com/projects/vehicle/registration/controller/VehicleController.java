package com.projects.vehicle.registration.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.vehicle.registration.dto.VehicleDTO;
import com.projects.vehicle.registration.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // 1. Register new vehicle
    @PostMapping
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO savedVehicle = vehicleService.addVehicle(vehicleDTO);
        return ResponseEntity.ok(savedVehicle);
    }

    // 2. Get all vehicles
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    // 3. Get vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // 4. Get vehicle by number
    @GetMapping("/search")
    public ResponseEntity<VehicleDTO> getByVehicleNumber(@RequestParam String number) {
        return ResponseEntity.ok(vehicleService.getByVehicleNumber(number));
    }
}