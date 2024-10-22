package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.time.LocalDate;
import org.springframework.web.client.RestTemplate;
import com.example.model.WeatherPincode;
import com.example.repository.WeatherPincodeRepository;

@Service
public class WeatherPincodeService {

    @Autowired
    private WeatherPincodeRepository weatherPincodeRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Geocoding and weather API keys
    private final String GEOCODING_API_KEY = "c420e2d91a9f1f0a9e8b3b8b7a15e3bc";
    private final String WEATHER_API_KEY = "c420e2d91a9f1f0a9e8b3b8b7a15e3bc";

    // Method to get weather data by pincode and date
    public WeatherPincode getWeatherByPincodeAndDate(String pincode, LocalDate date) {
        Optional<WeatherPincode> weatherDataOptional = weatherPincodeRepository.findByPincodeAndDate(pincode, date);

        if (weatherDataOptional.isPresent()) {
            return weatherDataOptional.get();
        }

        double[] latLong = getLatLongFromPincode(pincode);
        WeatherPincode weatherData = fetchWeatherFromOpenWeather(latLong[0], latLong[1], date);

        // Set the pincode, latitude, longitude, and date
        weatherData.setPincode(pincode);
        weatherData.setLatitude(latLong[0]);
        weatherData.setLongitude(latLong[1]);
        weatherData.setDate(date);

        // Save the weather data to the database
        weatherPincodeRepository.save(weatherData);

        return weatherData;
    }

    // Method to get latitude and longitude from pincode
    private double[] getLatLongFromPincode(String pincode) {
        String geocodingApiUrl = "http://api.openweathermap.org/geo/1.0/zip?zip=" + pincode + ",IN&appid=" + GEOCODING_API_KEY;
        
        Map<String, Object> response = restTemplate.getForObject(geocodingApiUrl, Map.class);
        
        double latitude = (double) response.get("lat");
        double longitude = (double) response.get("lon");

        return new double[]{ latitude, longitude };
    }

    // Method to fetch weather data from OpenWeather API
    private WeatherPincode fetchWeatherFromOpenWeather(double lat, double lon, LocalDate date) {
        String weatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + WEATHER_API_KEY;

        Map<String, Object> weatherResponse = restTemplate.getForObject(weatherApiUrl, Map.class);

        // Extract weather description
        List<Map<String, Object>> weatherList = (List<Map<String, Object>>) weatherResponse.get("weather");
        String description = (String) weatherList.get(0).get("description");

        // Extract main data like temperature and humidity
        Map<String, Object> mainData = (Map<String, Object>) weatherResponse.get("main");

        Number tempNumber = (Number) mainData.get("temp");
        double temperature = tempNumber.doubleValue();

        Number humidityNumber = (Number) mainData.get("humidity");
        double humidity = humidityNumber.doubleValue();

        // Create and return WeatherPincode object
        WeatherPincode weatherData = new WeatherPincode();
        weatherData.setWeatherDescription(description);
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);

        return weatherData;
    }
}
