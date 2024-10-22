package com.example.controller;
//import org.apache.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.WeatherPincode;
import com.example.service.WeatherPincodeService;

import java.util.Optional;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
public class WeatherPincodeController {

    @Autowired
    private WeatherPincodeService weatherPincodeService;

    @GetMapping("/pin")
    public WeatherPincode getWeatherForPincodeAndDate(@RequestParam String pincode, @RequestParam("for_date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        WeatherPincode weatherPincode=weatherPincodeService.getWeatherByPincodeAndDate(pincode, localDate);
        return weatherPincode;
    }

   // @PostMapping
   // public void saveWeatherForPincode(@RequestBody WeatherPincode weatherPincode, @RequestParam("for_date") String date) {
  //      LocalDate localDate = LocalDate.parse(date);
  //      weatherPincodeService.saveWeatherPincode(weatherPincode, localDate);
  //  }
}

