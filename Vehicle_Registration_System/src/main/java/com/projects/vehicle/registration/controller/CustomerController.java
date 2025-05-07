package com.projects.vehicle.registration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.vehicle.registration.dto.CustomerDTO;
import com.projects.vehicle.registration.model.User;
import com.projects.vehicle.registration.repository.UserRepository;
import com.projects.vehicle.registration.service.CustomerService;
//@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
    private final CustomerService customerService;
    @Autowired
    private final UserRepository userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
      
    public CustomerController(CustomerService customerService, UserRepository userRepo) {
		super();
		this.customerService = customerService;
		this.userRepo = userRepo;
	}

	// 1. Add new customer
    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO) {
    	User user=new User(customerDTO.getEmail(),passwordEncoder.encode(customerDTO.getPassword()),customerDTO.getUserType());
    	userRepo.save(user);
    	CustomerDTO dto=customerService.addCustomer(customerDTO);
    	dto.setUserType(user.getRoles());
        return ResponseEntity.ok(dto);
    }

    // 2. Get all customers
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    
    @GetMapping("/customersRegitrationCount")
    public ResponseEntity<List<Map<String, Object>>> getAllCustomersWithRegistrationCount() {
        return ResponseEntity.ok(customerService.getCustomerRegistrationStats());
    }

    // 3. Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    
    @GetMapping("/byMail")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@RequestParam String email) {
        return ResponseEntity.ok(customerService.findCustomerByEmail(email));
    }
}