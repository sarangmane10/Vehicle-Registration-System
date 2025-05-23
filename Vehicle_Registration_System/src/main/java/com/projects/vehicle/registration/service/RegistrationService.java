package com.projects.vehicle.registration.service;

import java.util.List;
import java.util.Map;

import com.projects.vehicle.registration.dto.RegistrationDTO;

public interface RegistrationService {
    RegistrationDTO registerVehicle(RegistrationDTO registrationDTO);
    RegistrationDTO getRegistrationById(Long id);
    List<RegistrationDTO> getAllRegistrations();
    RegistrationDTO updateRegistration(Long id, RegistrationDTO registrationDTO);
    void deleteRegistration(Long id);
    List<Map<String,Object>>getRegistrationDetails();
    int aproveActon(Long id,String message);
    List<RegistrationDTO> getRegistrationByCustomerId(Long id);
}