package com.example.controller;

import com.example.dto.CarRequestDto;
import com.example.dto.CarResponseDto;
import com.example.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getCars(@RequestBody CarRequestDto carRequestDto) {
        List<CarResponseDto> availableCars = carService.findAllAvailableCars(carRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }
}
