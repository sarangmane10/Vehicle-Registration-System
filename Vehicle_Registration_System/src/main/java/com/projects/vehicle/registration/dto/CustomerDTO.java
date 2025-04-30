package com.projects.vehicle.registration.dto;

import java.util.List; 

import jakarta.validation.constraints.Pattern;
import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CustomerDTO {

	
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    private String middleName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    @NotNull
    @Pattern(regexp  = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotNull
    @Size(max = 255)
    private String address;

    @NotNull
    @Size(max = 50)
    private String city;

    @NotNull
    @Size(max = 50)
    private String state;

    private int pinCode;

    private List<Long> registrationIds; // To represent related registrations
    
    private String password;

    private String userType;
    
    public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

     
	public CustomerDTO(Long id, @NotNull @Size(min = 1, max = 50) String firstName, String middleName,
			@NotNull @Size(min = 1, max = 50) String lastName, @NotNull @Email @Size(max = 100) String email,
			@NotNull @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits") String phoneNumber,
			@NotNull @Size(max = 255) String address, @NotNull @Size(max = 50) String city,
			@NotNull @Size(max = 50) String state, int pinCode, List<Long> registrationIds,
			@NotNull @Size(min = 8)String password,String userType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.registrationIds = registrationIds;
		this.password=password;
		this.userType=userType;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public List<Long> getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(List<Long> registrationIds) {
        this.registrationIds = registrationIds;
    }
    

    public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city="
				+ city + ", state=" + state + ", pinCode=" + pinCode + ", registrationIds=" + registrationIds
				+ ", password=" + password + ", userType=" + userType + "]";
	}


	
}