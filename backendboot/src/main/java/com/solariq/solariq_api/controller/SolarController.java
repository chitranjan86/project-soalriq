package com.solariq.solariq_api.controller;

import com.solariq.solariq_api.dto.SolarRequestDTO;
import com.solariq.solariq_api.dto.SolarResponseDTO;
import com.solariq.solariq_api.service.SolarCalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solar")
@CrossOrigin(origins = "http://localhost:3000")
public class SolarController {
    
    @Autowired
    private SolarCalculationService calculationService;
    
    @PostMapping("/calculate")
    public ResponseEntity<SolarResponseDTO> calculateSolar(@Valid @RequestBody SolarRequestDTO request) {
        SolarResponseDTO response = calculationService.calculateSolarPotential(request);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("SolarIQ API is running! 🌞");
    }
}