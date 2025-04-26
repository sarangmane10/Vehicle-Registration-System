package com.projects.vehicle.registration.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.vehicle.registration.dto.VehicleDTO;
import com.projects.vehicle.registration.model.Vehicle;
import com.projects.vehicle.registration.repository.VehicleRepository;


@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public VehicleDTO addVehicle(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle(
                null,
                dto.getVehicleNumber(),
                dto.getModel(),
                dto.getBrand(),
                dto.getColor(),
                dto.getYearOfManufacture(),
                dto.getPower(),
                dto.getMileage(),
                dto.getFuelType(),
                dto.getVehicleType(),
                null // registration will be handled separately
        );

        Vehicle saved = vehicleRepository.save(vehicle);
        return mapToDTO(saved);
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return mapToDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO dto) {
        Vehicle existing = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Vehicle updated = new Vehicle(
                existing.getId(),
                dto.getVehicleNumber(),
                dto.getModel(),
                dto.getBrand(),
                dto.getColor(),
                dto.getYearOfManufacture(),
                dto.getPower(),
                dto.getMileage(),
                dto.getFuelType(),
                dto.getVehicleType(),
                existing.getRegistration() // keep existing registration
        );

        Vehicle saved = vehicleRepository.save(updated);
        return mapToDTO(saved);
    }

    @Override
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found");
        }
        vehicleRepository.deleteById(id);
    }

    private VehicleDTO mapToDTO(Vehicle v) {
        return new VehicleDTO(
                v.getId(),
                v.getVehicleNumber(),
                v.getModel(),
                v.getBrand(),
                v.getColor(),
                v.getYearOfManufacture(),
                v.getPower(),
                v.getMileage(),
                v.getFuelType(),
                v.getVehicleType(),
                v.getRegistration().getId()
        );
    }

	@Override
	public VehicleDTO getByVehicleNumber(String number) {
		Vehicle vehicle = vehicleRepository.findByVehicleNumber(number)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return mapToDTO(vehicle);
	}
}