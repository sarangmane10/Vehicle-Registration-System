package com.projects.vehicle.registration.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vehicleNumber; // e.g., MH12AB1234

    private String model;
    private String brand;
    private String color;
    private int yearOfManufacture;
    private float power;
    private float mileage;
    private String fuelType; // e.g., Petrol, Diesel, Electric
    private String vehicleType; // e.g., Car, Bike, Truck

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private Registration registration;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(Long id, String vehicleNumber, String model, String brand, String color, int yearOfManufacture,
			float power, float mileage, String fuelType, String vehicleType, Registration registration) {
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
		this.registration = registration;
	}

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

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleNumber=" + vehicleNumber + ", model=" + model + ", brand=" + brand
				+ ", color=" + color + ", yearOfManufacture=" + yearOfManufacture + ", power=" + power + ", mileage="
				+ mileage + ", fuelType=" + fuelType + ", vehicleType=" + vehicleType + ", registration=" + registration
				+ "]";
	}

    
    
}
