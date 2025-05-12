package com.projects.vehicle.registration.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private int pinCode;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();
    
//    @OneToOne
//    @JoinColumn(name = "email", referencedColumnName = "email", unique = true)
//    private User user;
    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email", 
               insertable = false, updatable = false)
    private User user;
    
    

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id, String firstName, String middleName, String lastName, String email, String phoneNumber,
			String address, String city, String state, int pinCode, List<Registration> registrations) {
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
		this.registrations = registrations;
	}

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

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city="
				+ city + ", state=" + state + ", pinCode=" + pinCode + ", registrations=" + registrations + "]";
	}

    
}
