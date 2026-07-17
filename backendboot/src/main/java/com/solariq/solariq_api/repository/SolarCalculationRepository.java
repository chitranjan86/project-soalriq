package com.solariq.solariq_api.repository;

import com.solariq.solariq_api.entity.SolarCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolarCalculationRepository extends JpaRepository<SolarCalculation, Long> {
    List<SolarCalculation> findByUserId(Long userId);
}