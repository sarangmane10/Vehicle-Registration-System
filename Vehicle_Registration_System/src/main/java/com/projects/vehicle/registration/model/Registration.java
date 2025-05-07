package com.projects.vehicle.registration.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Customer customer;

    private LocalDate registrationDate;
    private LocalDate expiryDate;
    private String registrationLocation;
    private String status;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(Long id, Vehicle vehicle, Customer customer, LocalDate registrationDate, LocalDate expiryDate,
			String registrationLocation, String status) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.customer = customer;
		this.registrationDate = registrationDate;
		this.expiryDate = expiryDate;
		this.registrationLocation = registrationLocation;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getRegistrationLocation() {
		return registrationLocation;
	}
	public void setRegistrationLocation(String registrationLocation) {
		this.registrationLocation = registrationLocation;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
	@Override
	public String toString() {
		return "Registration [id=" + id + ", vehicle=" + vehicle + ", customer=" + customer + ", registrationDate="
				+ registrationDate + ", expiryDate=" + expiryDate + ", registrationLocation=" + registrationLocation
				+ ", active=" + status + "]";
	}
	

    
}
