package com.projects.vehicle.registration.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true, nullable = false)
//    private String vehicleNumber; // e.g., MH12AB1234

    private String model;
    private String brand;
    @ElementCollection
    @CollectionTable(name = "vehicle_colors", joinColumns = @JoinColumn(name = "vehicle_id"))
    @Column(name = "color")
    private List<String> colors;
    private int yearOfManufacture;
    private float power;
    private float mileage;
    private String fuelType; // e.g., Petrol, Diesel, Electric
    private String vehicleType; // e.g., Car, Bike, Truck
    private String engineType;
    private String transmission;
    @Lob
    private String image;
    private Long price;
    private String status;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Registration> registration;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(Long id, String model, String brand, List<String> colors, int yearOfManufacture,
			float power, float mileage, String fuelType, String vehicleType, List<Registration> registration,String engineType,
     String transmission,String image,Long price,String status) {
		super();
		this.id = id;
//		this.vehicleNumber = vehicleNumber;
		this.model = model;
		this.brand = brand;
		this.colors = colors;
		this.yearOfManufacture = yearOfManufacture;
		this.power = power;
		this.mileage = mileage;
		this.fuelType = fuelType;
		this.vehicleType = vehicleType;
		this.registration = registration;
		this.engineType=engineType;
		this.transmission=transmission;
		this.image=image;
		this.price=price;
		this.status=status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getVehicleNumber() {
//		return vehicleNumber;
//	}
//
//	public void setVehicleNumber(String vehicleNumber) {
//		this.vehicleNumber = vehicleNumber;
//	}

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

	public List<Registration> getRegistration() {
		return registration;
	}

	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}
	

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	
	public List<String> getColors() {
		return colors;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleNumber=" + ", model=" + model + ", brand=" + brand
				+ ", color=" + colors + ", yearOfManufacture=" + yearOfManufacture + ", power=" + power + ", mileage="
				+ mileage + ", fuelType=" + fuelType + ", vehicleType=" + vehicleType + ", registration=" + registration
				+ "]";
	}

    
    
}
