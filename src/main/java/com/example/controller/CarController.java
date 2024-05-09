package com.example.controller;

import com.example.dto.CarResponseDto;
import com.example.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAvailableCars(
            @RequestParam LocalDate pickupDate,
            @RequestParam LocalDate returnDate,
            @RequestParam(required = false) String toCurrency
    ) {
        List<CarResponseDto> availableCars;
        if (toCurrency == null) {
            availableCars = carService.getAvailableCars(pickupDate, returnDate);
        } else {
            availableCars = carService.getAvailableCars(pickupDate, returnDate, toCurrency);
        }

        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarResponseDto> getCarById(@PathVariable("carId") String carId) {
       return ResponseEntity.status(HttpStatus.OK).body(carService.getCarById(carId));
    }
}