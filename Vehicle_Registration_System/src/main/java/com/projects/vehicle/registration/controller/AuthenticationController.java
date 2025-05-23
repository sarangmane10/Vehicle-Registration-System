package com.projects.vehicle.registration.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projects.vehicle.registration.dto.CustomerDTO;
import com.projects.vehicle.registration.dto.LoginRequest;
import com.projects.vehicle.registration.model.User;
import com.projects.vehicle.registration.repository.UserRepository;
import com.projects.vehicle.registration.service.CustomerService;
//@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class AuthenticationController {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            // 1. Find user
            User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
            
            // 2. Verify password
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                response.put("status", "error");
                response.put("message", "Invalid credentials");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
            
            // 3. Prepare success response based on role
            response.put("status", "success");
            CustomerDTO customer = customerService.findCustomerByEmail(user.getEmail());
            if ("USER".equals(user.getRoles())) {
                response.put("message", "Welcome Customer: " + customer.getFirstName());
                response.put("user", customer);
                response.put("role", "USER");
            } else if ("ADMIN".equals(user.getRoles())) {
                response.put("message", "Welcome Admin");
                response.put("user", customer);
                response.put("role", "ADMIN");
            } else {
                response.put("message", "Unknown user type");
                return ResponseEntity.badRequest().body(response);
            }
            
            // 4. Return successful response
            return ResponseEntity.ok(response);
            
        } catch (ResponseStatusException ex) {
            response.put("status", "error");
            response.put("message", ex.getReason());
            return ResponseEntity.status(ex.getStatusCode()).body(response);
        } catch (Exception ex) {
            response.put("status", "error");
            response.put("message", "Login failed");
            return ResponseEntity.internalServerError().body(response);
        }
    }
    
    @PostMapping("/resetPassword")
    public ResponseEntity<Map<String,Object>> resetPassword(@RequestBody Map<String,String> data){
    	User user=userRepository.findByEmail(data.get("email")).get();
    	user.setPassword(passwordEncoder.encode(data.get("password")));
    	User u=userRepository.save(user);
    	if(u!=null)
    		return ResponseEntity.ok(Map.of("status","success"));
    	else
    		return ResponseEntity.ok(Map.of("status","error"));
    	
    }
}