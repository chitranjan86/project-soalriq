package com.solariq.solariq_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class SolarRequestDTO {
    
    @NotNull(message = "Rooftop area is required")
    @Positive(message = "Rooftop area must be positive")
    private Double rooftopArea;
    
    @NotNull(message = "Monthly bill is required")
    @Positive(message = "Monthly bill must be positive")
    private Double monthlyBill;
    
    @NotNull(message = "Electricity rate is required")
    @Positive(message = "Electricity rate must be positive")
    private Double electricityRate;
    
    @NotNull(message = "Sunlight hours is required")
    @Positive(message = "Sunlight hours must be positive")
    private Integer sunlightHours;
    
    private String name;
    private String email;
    private String phone;
    private String city;
    private String state;
    
    // Default constructor
    public SolarRequestDTO() {}
    
    // Getters
    public Double getRooftopArea() { return rooftopArea; }
    public Double getMonthlyBill() { return monthlyBill; }
    public Double getElectricityRate() { return electricityRate; }
    public Integer getSunlightHours() { return sunlightHours; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getState() { return state; }
    
    // Setters
    public void setRooftopArea(Double rooftopArea) { this.rooftopArea = rooftopArea; }
    public void setMonthlyBill(Double monthlyBill) { this.monthlyBill = monthlyBill; }
    public void setElectricityRate(Double electricityRate) { this.electricityRate = electricityRate; }
    public void setSunlightHours(Integer sunlightHours) { this.sunlightHours = sunlightHours; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
}