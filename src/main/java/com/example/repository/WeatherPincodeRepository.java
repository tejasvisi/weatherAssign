package com.example.repository;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.WeatherPincode;

public interface WeatherPincodeRepository extends JpaRepository<WeatherPincode, String> {
    Optional<WeatherPincode> findByPincodeAndDate(String pincode, LocalDate date);
}
