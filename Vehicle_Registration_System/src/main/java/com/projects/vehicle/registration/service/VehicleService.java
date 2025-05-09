package com.projects.vehicle.registration.service;

import java.util.List;

import com.projects.vehicle.registration.dto.VehicleDTO;

public interface VehicleService {
    VehicleDTO addVehicle(VehicleDTO dto);
    VehicleDTO getVehicleById(Long id);
//    VehicleDTO getByVehicleNumber(String number);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO updateVehicle(Long id, VehicleDTO dto);
    void deleteVehicle(Long id);
    VehicleDTO editVehicle(VehicleDTO vehicle);
}