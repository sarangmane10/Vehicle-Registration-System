package com.projects.vehicle.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.vehicle.registration.dto.VehicleDTO;
import com.projects.vehicle.registration.model.Vehicle;
import com.projects.vehicle.registration.repository.VehicleRepository;


@Service
public class VehicleServiceImpl implements VehicleService {

    private final SecurityConfig securityConfig;

    @Autowired
    private VehicleRepository vehicleRepository;

    VehicleServiceImpl(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO dto) {
    	System.out.println(dto.getColors());
        Vehicle vehicle = new Vehicle(
                null,
                dto.getModel(),
                dto.getBrand(),
                dto.getColors(),
                dto.getYearOfManufacture(),
                dto.getPower(),
                dto.getMileage(),
                dto.getFuelType(),
                dto.getVehicleType(),
                null, // registration will be handled separately
                dto.getEngineType(),
                dto.getTransmission(),
                dto.getImage(),
                dto.getPrice(),
                dto.getStatus()
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
    	List<VehicleDTO> vehicleDTOList = new ArrayList<>();
    	for (Vehicle vehicle : vehicleRepository.findAll()) {
    		vehicle.setColors(vehicleRepository.FindColorsById(vehicle.getId()));
    		
    	    vehicleDTOList.add(mapToDTO(vehicle));
    	}
    	return vehicleDTOList;

    }

    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO dto) {
        Vehicle existing = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Vehicle updated = new Vehicle(
                existing.getId(),
                dto.getModel(),
                dto.getBrand(),
                dto.getColors(),
                dto.getYearOfManufacture(),
                dto.getPower(),
                dto.getMileage(),
                dto.getFuelType(),
                dto.getVehicleType(),
                existing.getRegistration(), // keep existing registration
                dto.getEngineType(),
                dto.getTransmission(),
                dto.getImage(),
                dto.getPrice(),
                dto.getStatus()
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
    
    @Override
	public VehicleDTO editVehicle(VehicleDTO vehicle) {
//    	System.out.println("hello");
		Vehicle v=vehicleRepository.findById(vehicle.getId()).get();
	    v.setModel(vehicle.getModel());
	    v.setBrand(vehicle.getBrand());
	    
	    // For list fields, create a new ArrayList to avoid reference sharing
	    if (vehicle.getColors() != null) {
	        v.setColors(new ArrayList<>(vehicle.getColors()));
	    } else {
	        v.setColors(null);
	    }
	    
	    v.setYearOfManufacture(vehicle.getYearOfManufacture());
	    v.setPower(vehicle.getPower());
	    v.setMileage(vehicle.getMileage());
	    v.setFuelType(vehicle.getFuelType());
	    v.setVehicleType(vehicle.getVehicleType());
	    
	    v.setEngineType(vehicle.getEngineType());
	    v.setTransmission(vehicle.getTransmission());
	    v.setImage(vehicle.getImage());
	    v.setPrice(vehicle.getPrice());
	    v.setStatus(vehicle.getStatus());
	    return mapToDTO(vehicleRepository.save(v));
	}

    private VehicleDTO mapToDTO(Vehicle v) {
    	List<Long> id=null;
//    	if(v.getRegistration()!=null) {
//    		for(Registration i:v.getRegistration())
//            id.add(i.getId());
//    	}
        
		return new VehicleDTO(
                v.getId(),
                v.getModel(),
                v.getBrand(),
                v.getColors(),
                v.getYearOfManufacture(),
                v.getPower(),
                v.getMileage(),
                v.getFuelType(),
                v.getVehicleType(),
                id,
                v.getEngineType(),
                v.getTransmission(),
                v.getImage(),
                v.getPrice(),
                v.getStatus()
        );
    }

//	@Override
//	public VehicleDTO getByVehicleNumber(String number) {
//		Vehicle vehicle = vehicleRepository.findByVehicleNumber(number)
//                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
//        return mapToDTO(vehicle);
//	}
}