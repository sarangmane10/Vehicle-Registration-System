package com.projects.vehicle.registration.service;

import java.util.List;
import java.util.Map;

import com.projects.vehicle.registration.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO addCustomer(CustomerDTO dto);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long id, CustomerDTO dto);
    void deleteCustomer(Long id);
    CustomerDTO findCustomerByEmail(String email);
    List<Map<String, Object>> getCustomerRegistrationStats();
}