package com.projects.vehicle.registration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.vehicle.registration.dto.RegistrationDTO;
import com.projects.vehicle.registration.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // 1. Register a vehicle to a customer
    @PostMapping
    public ResponseEntity<RegistrationDTO> registerVehicle(@RequestBody RegistrationDTO dto) {
        return ResponseEntity.ok(registrationService.registerVehicle(dto));
    }

    // 2. Get registration by ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> getRegistrationById(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.getRegistrationById(id));
    }

    // 3. Get all registrations
    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> getAllRegistrations() {
    	System.out.println("fsdfs");
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }
    
    @GetMapping("/details")
    public ResponseEntity<List<Map<String,Object>>> getRegistrationDetails() {
        return ResponseEntity.ok(registrationService.getRegistrationDetails());
    }
    
    @PostMapping("/action/{id}")
    public ResponseEntity<Map<String,Object>> approveReject(@PathVariable Long id,@RequestParam String message) {
        int status =registrationService.aproveActon(id,message);
        Map<String,Object>res =new HashMap<String, Object>();
        if(status>=1) {
        	res.put("message", "updated");
        	return ResponseEntity.ok(res);
        }else {
        	res.put("message", "error");
        	return ResponseEntity.ok(res);
        }
    }
    
    @GetMapping("/byCustomerId/{id}")
    public ResponseEntity<List<RegistrationDTO>> getRegistrationByCustomerId(@PathVariable Long id) {
        return ResponseEntity.ok(registrationService.getRegistrationByCustomerId(id));
    }
    
    
}