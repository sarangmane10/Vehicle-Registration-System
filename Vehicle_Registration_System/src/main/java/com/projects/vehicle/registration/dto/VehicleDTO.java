package com.projects.vehicle.registration.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VehicleDTO {
	private Long id;

    @NotNull
    @Size(min = 1, max = 15)
    private String vehicleNumber; // e.g., MH12AB1234

    private String model;
    private String brand;
    private String color;

    @NotNull
    private int yearOfManufacture;

    private float power;
    private float mileage;
    
    
    public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

        
	public VehicleDTO(Long id, @NotNull @Size(min = 1, max = 15) String vehicleNumber, String model, String brand,
			String color, @NotNull int yearOfManufacture, float power, float mileage,
			@NotNull @Size(max = 20) String fuelType, @NotNull @Size(max = 20) String vehicleType,
			Long registrationId) {
		super();
		this.id = id;
		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.yearOfManufacture = yearOfManufacture;
		this.power = power;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.vehicleType = vehicleType;
		this.registrationId = registrationId;
	}


	@NotNull
    @Size(max = 20)
    private String fuelType; // e.g., Petrol, Diesel, Electric

    @NotNull
    @Size(max = 20)
    private String vehicleType; // e.g., Car, Bike, Truck

    private Long registrationId; // To represent related registration, instead of embedding full Registration object

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public String toString() {
        return "VehicleDTO [id=" + id + ", vehicleNumber=" + vehicleNumber + ", model=" + model + ", brand=" + brand
                + ", color=" + color + ", yearOfManufacture=" + yearOfManufacture + ", power=" + power + ", mileage="
                + mileage + ", fuelType=" + fuelType + ", vehicleType=" + vehicleType + ", registrationId="
                + registrationId + "]";
    }
}
