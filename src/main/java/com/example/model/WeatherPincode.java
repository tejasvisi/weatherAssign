package com.example.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class WeatherPincode {
    
    @Id
    private String pincode;
    private double latitude;
    private double longitude;
    
    // Weather fields
    private double temperature;
    private double humidity;
    private String weatherDescription;
    private LocalDate date;  // New date field

    // Getters, Setters, Constructors
    public WeatherPincode() {}

    public WeatherPincode(String pincode, double latitude, double longitude, double temperature, double humidity, String weatherDescription, LocalDate date) {
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.humidity = humidity;
        this.weatherDescription = weatherDescription;
        this.date = date;
    }

    // Getters and Setters
    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
