package com.solariq.solariq_api.service;

import com.solariq.solariq_api.dto.SolarRequestDTO;
import com.solariq.solariq_api.dto.SolarResponseDTO;
import com.solariq.solariq_api.entity.SolarCalculation;
import com.solariq.solariq_api.entity.User;
import com.solariq.solariq_api.repository.SolarCalculationRepository;
import com.solariq.solariq_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolarCalculationService {
    
    @Autowired
    private SolarCalculationRepository calculationRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    private static final double PANEL_EFFICIENCY = 0.2;
    private static final double PANEL_AREA = 1.7;
    private static final double PANEL_CAPACITY = 0.4;
    private static final double COST_PER_KW = 45000.0;
    private static final double CO2_PER_KWH = 0.82;
    private static final double SUBSIDY_PERCENTAGE = 0.4;
    private static final double MAX_SUBSIDY = 300000.0;
    private static final double SYSTEM_LIFE = 25.0;
    
    public SolarResponseDTO calculateSolarPotential(SolarRequestDTO request) {
        User user = findOrCreateUser(request);
        
        int maxPanels = (int) (request.getRooftopArea() / PANEL_AREA);
        double maxSystemSize = maxPanels * PANEL_CAPACITY;
        
        double monthlyConsumption = request.getMonthlyBill() / request.getElectricityRate();
        double dailyConsumption = monthlyConsumption / 30;
        double requiredSystemSize = dailyConsumption / (request.getSunlightHours() * PANEL_EFFICIENCY);
        
        double recommendedSize = Math.min(maxSystemSize, requiredSystemSize);
        recommendedSize = Math.round(recommendedSize * 100.0) / 100.0;
        
        int panelsRequired = (int) Math.ceil(recommendedSize / PANEL_CAPACITY);
        double roofAreaUsed = panelsRequired * PANEL_AREA;
        
        double installationCost = recommendedSize * COST_PER_KW;
        double subsidy = calculateSubsidy(recommendedSize);
        double netCost = installationCost - subsidy;
        
        double annualGeneration = recommendedSize * request.getSunlightHours() * 365 * PANEL_EFFICIENCY;
        
        double annualSavings = Math.min(annualGeneration * request.getElectricityRate(), 
                                        request.getMonthlyBill() * 12);
        double monthlySavings = annualSavings / 12;
        
        double paybackYears = netCost / annualSavings;
        paybackYears = Math.round(paybackYears * 10.0) / 10.0;
        
        double lifetimeSavings = annualSavings * SYSTEM_LIFE;
        double roi = ((lifetimeSavings - netCost) / netCost) * 100;
        
        double co2Reduction = (annualGeneration * CO2_PER_KWH) / 1000;
        double treesEquivalent = co2Reduction * 45;
        
        SolarCalculation calculation = new SolarCalculation();
        calculation.setUser(user);
        calculation.setRooftopArea(request.getRooftopArea());
        calculation.setMonthlyBill(request.getMonthlyBill());
        calculation.setElectricityRate(request.getElectricityRate());
        calculation.setSunlightHours(request.getSunlightHours());
        calculation.setSystemSize(recommendedSize);
        calculation.setInstallationCost(installationCost);
        calculation.setAnnualGeneration(annualGeneration);
        calculation.setAnnualSavings(annualSavings);
        calculation.setRoiYears(paybackYears);
        calculation.setCo2Reduction(co2Reduction);
        calculation.setSubsidyAmount(subsidy);
        
        calculationRepository.save(calculation);
        
        return SolarResponseDTO.builder()
                .calculationId(calculation.getId())
                .userName(user.getName())
                .rooftopArea(request.getRooftopArea())
                .monthlyBill(request.getMonthlyBill())
                .electricityRate(request.getElectricityRate())
                .sunlightHours(request.getSunlightHours())
                .recommendedSystemSize(recommendedSize)
                .installationCost(installationCost)
                .annualEnergyGeneration(annualGeneration)
                .annualElectricitySavings(annualSavings)
                .monthlySavings(monthlySavings)
                .paybackPeriod(paybackYears)
                .co2Reduction(co2Reduction)
                .treesEquivalent(treesEquivalent)
                .governmentSubsidy(subsidy)
                .netCost(netCost)
                .roiPercentage(roi)
                .panelsRequired(panelsRequired)
                .roofAreaUsed(roofAreaUsed)
                .systemSizeRecommendation(getSystemRecommendation(recommendedSize))
                .financialVerdict(getFinancialVerdict(paybackYears, roi))
                .build();
    }
    
    private User findOrCreateUser(SolarRequestDTO request) {
        return userRepository.findByEmail(request.getEmail())
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setName(request.getName());
                    newUser.setEmail(request.getEmail());
                    newUser.setPhone(request.getPhone());
                    newUser.setCity(request.getCity());
                    newUser.setState(request.getState());
                    return userRepository.save(newUser);
                });
    }
    
    private double calculateSubsidy(double systemSize) {
        if (systemSize <= 3) {
            return Math.min(systemSize * COST_PER_KW * SUBSIDY_PERCENTAGE, MAX_SUBSIDY);
        } else if (systemSize <= 10) {
            double subsidy = (3 * COST_PER_KW * 0.4) + ((systemSize - 3) * COST_PER_KW * 0.2);
            return Math.min(subsidy, MAX_SUBSIDY);
        } else {
            return MAX_SUBSIDY;
        }
    }
    
    private String getSystemRecommendation(double systemSize) {
        if (systemSize < 1) return "Small system - Suitable for basic needs";
        if (systemSize < 3) return "Medium system - Ideal for average household";
        if (systemSize < 5) return "Large system - Can power most appliances";
        return "Commercial scale - Suitable for business";
    }
    
    private String getFinancialVerdict(double paybackYears, double roi) {
        if (paybackYears < 4) return "Excellent Investment!";
        if (paybackYears < 7) return "Good Investment!";
        if (paybackYears < 10) return "Fair Investment";
        return "Long-term Investment - Consider other factors";
    }
}