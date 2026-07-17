package com.solariq.solariq_api.dto;

public class SolarResponseDTO {
    
    private Long calculationId;
    private String userName;
    private Double rooftopArea;
    private Double monthlyBill;
    private Double electricityRate;
    private Integer sunlightHours;
    private Double recommendedSystemSize;
    private Double installationCost;
    private Double annualEnergyGeneration;
    private Double annualElectricitySavings;
    private Double monthlySavings;
    private Double paybackPeriod;
    private Double co2Reduction;
    private Double treesEquivalent;
    private Double governmentSubsidy;
    private Double netCost;
    private Double roiPercentage;
    private String systemSizeRecommendation;
    private String financialVerdict;
    private Integer panelsRequired;
    private Double roofAreaUsed;
    
    // Private constructor
    private SolarResponseDTO() {}
    
    // Getters
    public Long getCalculationId() { return calculationId; }
    public String getUserName() { return userName; }
    public Double getRooftopArea() { return rooftopArea; }
    public Double getMonthlyBill() { return monthlyBill; }
    public Double getElectricityRate() { return electricityRate; }
    public Integer getSunlightHours() { return sunlightHours; }
    public Double getRecommendedSystemSize() { return recommendedSystemSize; }
    public Double getInstallationCost() { return installationCost; }
    public Double getAnnualEnergyGeneration() { return annualEnergyGeneration; }
    public Double getAnnualElectricitySavings() { return annualElectricitySavings; }
    public Double getMonthlySavings() { return monthlySavings; }
    public Double getPaybackPeriod() { return paybackPeriod; }
    public Double getCo2Reduction() { return co2Reduction; }
    public Double getTreesEquivalent() { return treesEquivalent; }
    public Double getGovernmentSubsidy() { return governmentSubsidy; }
    public Double getNetCost() { return netCost; }
    public Double getRoiPercentage() { return roiPercentage; }
    public String getSystemSizeRecommendation() { return systemSizeRecommendation; }
    public String getFinancialVerdict() { return financialVerdict; }
    public Integer getPanelsRequired() { return panelsRequired; }
    public Double getRoofAreaUsed() { return roofAreaUsed; }
    
    // Builder pattern
    public static Builder builder() { return new Builder(); }
    
    public static class Builder {
        private SolarResponseDTO dto = new SolarResponseDTO();
        
        public Builder calculationId(Long val) { dto.calculationId = val; return this; }
        public Builder userName(String val) { dto.userName = val; return this; }
        public Builder rooftopArea(Double val) { dto.rooftopArea = val; return this; }
        public Builder monthlyBill(Double val) { dto.monthlyBill = val; return this; }
        public Builder electricityRate(Double val) { dto.electricityRate = val; return this; }
        public Builder sunlightHours(Integer val) { dto.sunlightHours = val; return this; }
        public Builder recommendedSystemSize(Double val) { dto.recommendedSystemSize = val; return this; }
        public Builder installationCost(Double val) { dto.installationCost = val; return this; }
        public Builder annualEnergyGeneration(Double val) { dto.annualEnergyGeneration = val; return this; }
        public Builder annualElectricitySavings(Double val) { dto.annualElectricitySavings = val; return this; }
        public Builder monthlySavings(Double val) { dto.monthlySavings = val; return this; }
        public Builder paybackPeriod(Double val) { dto.paybackPeriod = val; return this; }
        public Builder co2Reduction(Double val) { dto.co2Reduction = val; return this; }
        public Builder treesEquivalent(Double val) { dto.treesEquivalent = val; return this; }
        public Builder governmentSubsidy(Double val) { dto.governmentSubsidy = val; return this; }
        public Builder netCost(Double val) { dto.netCost = val; return this; }
        public Builder roiPercentage(Double val) { dto.roiPercentage = val; return this; }
        public Builder systemSizeRecommendation(String val) { dto.systemSizeRecommendation = val; return this; }
        public Builder financialVerdict(String val) { dto.financialVerdict = val; return this; }
        public Builder panelsRequired(Integer val) { dto.panelsRequired = val; return this; }
        public Builder roofAreaUsed(Double val) { dto.roofAreaUsed = val; return this; }
        
        public SolarResponseDTO build() { return dto; }
    }
}