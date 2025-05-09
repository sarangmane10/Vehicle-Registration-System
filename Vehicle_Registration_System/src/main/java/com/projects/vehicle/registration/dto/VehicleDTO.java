package com.projects.vehicle.registration.dto;

import java.util.List;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VehicleDTO {
	private Long id;

//    @NotNull
//    @Size(min = 1, max = 15)
//    private String vehicleNumber; // e.g., MH12AB1234

    private String model;
    private String brand;
    private List<String> colors;

    @NotNull
    private int yearOfManufacture;
   
//	private MultipartFile image;
    private float power;
    private float mileage;
    
    @NotNull
    @Size(max = 20)
    private String fuelType; // e.g., Petrol, Diesel, Electric

    @NotNull
    @Size(max = 20)
    private String vehicleType; // e.g., Car, Bike, Truck

    private List<Long> registrationId; // To represent related registration, instead of embedding full Registration object
    private String engineType;
    private String transmission;
    @Lob
    private String image;
    private Long price;
    private String status;
    
    
    public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

        
	public VehicleDTO(Long id, String model, String brand,
			List<String> colors, @NotNull int yearOfManufacture, float power, float mileage,
			@NotNull @Size(max = 20) String fuelType, @NotNull @Size(max = 20) String vehicleType,
			List<Long> registrationId,String engineType,
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
		this.registrationId = registrationId;
//		this.image=image;
		this.engineType=engineType;
		this.transmission=transmission;
		this.image=image;
		this.price=price;
		this.status=status;
	}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getVehicleNumber() {
//        return vehicleNumber;
//    }
//
//    public void setVehicleNumber(String vehicleNumber) {
//        this.vehicleNumber = vehicleNumber;
//    }

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

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
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

    public List<Long> getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(List<Long> registrationId) {
        this.registrationId = registrationId;
    }
    
//    public MultipartFile getImage() {
//		return image;
//	}
//
//
//	public void setImage(MultipartFile image) {
//		this.image = image;
//	}
    
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
        return "VehicleDTO [id=" + id + ", vehicleNumber="  + ", model=" + model + ", brand=" + brand
                + ", color=" + colors + ", yearOfManufacture=" + yearOfManufacture + ", power=" + power + ", mileage="
                + mileage + ", fuelType=" + fuelType + ", vehicleType=" + vehicleType + ", registrationId="
                + registrationId + "]";
    }

}
