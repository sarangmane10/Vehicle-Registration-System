package com.projects.vehicle.registration.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.vehicle.registration.dto.RegistrationDTO;
import com.projects.vehicle.registration.model.Customer;
import com.projects.vehicle.registration.model.Registration;
import com.projects.vehicle.registration.model.Vehicle;
import com.projects.vehicle.registration.repository.CustomerRepository;
import com.projects.vehicle.registration.repository.RegistrationRepository;
import com.projects.vehicle.registration.repository.VehicleRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public RegistrationDTO registerVehicle(RegistrationDTO dto) {
        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Registration registration = new Registration(
                null,
                vehicle,
                customer,
                dto.getRegistrationDate(),
                dto.getExpiryDate(),
                dto.getRegistrationLocation(),
                dto.isActive()
        );

        Registration saved = registrationRepository.save(registration);
        return mapToDTO(saved);
    }

    @Override
    public RegistrationDTO getRegistrationById(Long id) {
        Registration reg = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));
        return mapToDTO(reg);
    }

    @Override
    public List<RegistrationDTO> getAllRegistrations() {
        return registrationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationDTO updateRegistration(Long id, RegistrationDTO dto) {
        Registration existing = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Use constructor to create a new Registration with updated values
        Registration updated = new Registration(
                existing.getId(), // retain same ID
                vehicle,
                customer,
                dto.getRegistrationDate(),
                dto.getExpiryDate(),
                dto.getRegistrationLocation(),
                dto.isActive()
        );

        return mapToDTO(registrationRepository.save(updated));
    }

    @Override
    public void deleteRegistration(Long id) {
        if (!registrationRepository.existsById(id)) {
            throw new RuntimeException("Registration not found");
        }
        registrationRepository.deleteById(id);
    }

    private RegistrationDTO mapToDTO(Registration reg) {
        return new RegistrationDTO(
                reg.getId(),
                reg.getVehicle().getId(),
                reg.getCustomer().getId(),
                reg.getRegistrationDate(),
                reg.getExpiryDate(),
                reg.getRegistrationLocation(),
                reg.isActive()
        );
    }
}