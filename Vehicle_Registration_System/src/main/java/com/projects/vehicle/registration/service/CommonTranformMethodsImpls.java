package com.projects.vehicle.registration.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Tuple;

public class CommonTranformMethodsImpls implements CommonTranformMethods{

	@Override
	public List<Map<String, Object>> transformToListOfMap(List<Tuple> tuples ) {
		
	        List<Map<String, Object>> customerStats = new ArrayList<>();
	        
	        for (Tuple tuple : tuples) {
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
	}

