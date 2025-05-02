package com.projects.vehicle.registration.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.vehicle.registration.dto.CustomerDTO;
import com.projects.vehicle.registration.model.Customer;
import com.projects.vehicle.registration.repository.CustomerRepository;

import jakarta.persistence.Tuple;

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
    
    public CustomerDTO findCustomerByEmail(String email) {
    	Customer customer = customerRepository.findByEmail(email)
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
    
    @Override
    public List<Map<String, Object>> getCustomerRegistrationStats() {
        List<Tuple> results = customerRepository.findCustomerRegistrationStats();
        List<Map<String, Object>> customerStats = new ArrayList<>();
        
        for (Tuple tuple : results) {
            Map<String, Object> customerData = new LinkedHashMap<>();
            customerData.put("id", tuple.get("id", Long.class));
            customerData.put("firstName", tuple.get("firstName", String.class));
            customerData.put("lastName", tuple.get("lastName", String.class));
            customerData.put("email", tuple.get("email", String.class));
            customerData.put("phoneNumber", tuple.get("phoneNumber", String.class));
            customerData.put("registrations", tuple.get("registrations", Long.class));
            
            customerStats.add(customerData);
        }
        
        return customerStats;
    }

    private CustomerDTO mapToDTO(Customer c) {
    	List<Long>regId=new ArrayList<>();
    	if(c.getRegistrations()!=null)
    		regId=c.getRegistrations().stream().map(r -> r.getId()).collect(Collectors.toList());
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
                regId,
                "",
                ""
        );
    }
    
}