package com.solariq.solariq_api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolariqApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolariqApplication.class, args);
        System.out.println("🌞 SolarIQ Backend Started Successfully!");
    }
}