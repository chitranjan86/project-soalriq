package com.solariq.solariq_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solar_calculations")
public class SolarCalculation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private Double rooftopArea;
    private Double monthlyBill;
    private Double electricityRate;
    private Integer sunlightHours;
    
    private Double systemSize;
    private Double installationCost;
    private Double annualGeneration;
    private Double annualSavings;
    private Double roiYears;
    private Double co2Reduction;
    private Double subsidyAmount;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    // Default constructor
    public SolarCalculation() {}
    
    // Getters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public Double getRooftopArea() { return rooftopArea; }
    public Double getMonthlyBill() { return monthlyBill; }
    public Double getElectricityRate() { return electricityRate; }
    public Integer getSunlightHours() { return sunlightHours; }
    public Double getSystemSize() { return systemSize; }
    public Double getInstallationCost() { return installationCost; }
    public Double getAnnualGeneration() { return annualGeneration; }
    public Double getAnnualSavings() { return annualSavings; }
    public Double getRoiYears() { return roiYears; }
    public Double getCo2Reduction() { return co2Reduction; }
    public Double getSubsidyAmount() { return subsidyAmount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setRooftopArea(Double rooftopArea) { this.rooftopArea = rooftopArea; }
    public void setMonthlyBill(Double monthlyBill) { this.monthlyBill = monthlyBill; }
    public void setElectricityRate(Double electricityRate) { this.electricityRate = electricityRate; }
    public void setSunlightHours(Integer sunlightHours) { this.sunlightHours = sunlightHours; }
    public void setSystemSize(Double systemSize) { this.systemSize = systemSize; }
    public void setInstallationCost(Double installationCost) { this.installationCost = installationCost; }
    public void setAnnualGeneration(Double annualGeneration) { this.annualGeneration = annualGeneration; }
    public void setAnnualSavings(Double annualSavings) { this.annualSavings = annualSavings; }
    public void setRoiYears(Double roiYears) { this.roiYears = roiYears; }
    public void setCo2Reduction(Double co2Reduction) { this.co2Reduction = co2Reduction; }
    public void setSubsidyAmount(Double subsidyAmount) { this.subsidyAmount = subsidyAmount; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}