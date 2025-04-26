package com.projects.vehicle.registration.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.vehicle.registration.dto.CustomerDTO;
import com.projects.vehicle.registration.model.Customer;
import com.projects.vehicle.registration.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO addCustomer(CustomerDTO dto) {
        Customer customer = new Customer(
                null,
                dto.getFirstName(),
                dto.getMiddleName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getPinCode(),
                null // registrations will be handled separately
        );

        Customer saved = customerRepository.save(customer);
        return mapToDTO(saved);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapToDTO(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Customer updated = new Customer(
                existing.getId(),
                dto.getFirstName(),
                dto.getMiddleName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                dto.getAddress(),
                dto.getCity(),
                dto.getState(),
                dto.getPinCode(),
                existing.getRegistrations() // keep existing registrations
        );

        Customer saved = customerRepository.save(updated);
        return mapToDTO(saved);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapToDTO(Customer c) {
        return new CustomerDTO(
                c.getId(),
                c.getFirstName(),
                c.getMiddleName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhoneNumber(),
                c.getAddress(),
                c.getCity(),
                c.getState(),
                c.getPinCode(),
                c.getRegistrations().stream().map(r -> r.getId()).collect(Collectors.toList())

        );
    }
}