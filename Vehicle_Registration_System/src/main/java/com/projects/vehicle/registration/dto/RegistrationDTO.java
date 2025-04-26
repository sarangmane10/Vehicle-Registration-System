package com.projects.vehicle.registration.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationDTO {

    private Long id;

    @NotNull
    private Long vehicleId;  // Vehicle ID instead of embedding the whole vehicle object

    @NotNull
    private Long customerId;  // Customer ID instead of embedding the whole customer object

    @NotNull
    private LocalDate registrationDate;

    private LocalDate expiryDate;

    @NotNull
    @Size(max = 50)
    private String registrationLocation;

    private boolean active;
    
    

    public RegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrationDTO(Long id, @NotNull Long vehicleId, @NotNull Long customerId,
			@NotNull LocalDate registrationDate, LocalDate expiryDate,
			@NotNull @Size(max = 50) String registrationLocation, boolean active) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.customerId = customerId;
		this.registrationDate = registrationDate;
		this.expiryDate = expiryDate;
		this.registrationLocation = registrationLocation;
		this.active = active;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
        return "RegistrationDTO [id=" + id + ", vehicleId=" + vehicleId + ", customerId=" + customerId
                + ", registrationDate=" + registrationDate + ", expiryDate=" + expiryDate + ", registrationLocation="
                + registrationLocation + ", active=" + active + "]";
    }
}
