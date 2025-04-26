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

    @OneToOne
    private Vehicle vehicle;

    @ManyToOne
    private Customer customer;

    private LocalDate registrationDate;
    private LocalDate expiryDate;
    private String registrationLocation;
    private boolean active;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(Long id, Vehicle vehicle, Customer customer, LocalDate registrationDate, LocalDate expiryDate,
			String registrationLocation, boolean active) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.customer = customer;
		this.registrationDate = registrationDate;
		this.expiryDate = expiryDate;
		this.registrationLocation = registrationLocation;
		this.active = active;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "Registration [id=" + id + ", vehicle=" + vehicle + ", customer=" + customer + ", registrationDate="
				+ registrationDate + ", expiryDate=" + expiryDate + ", registrationLocation=" + registrationLocation
				+ ", active=" + active + "]";
	}
	

    
}
