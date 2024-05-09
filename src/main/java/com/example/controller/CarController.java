package com.example.controller;
/*
import com.example.currencyConverter.CurrencyConverterClient;


 */
import com.example.dto.CarRequestDto;
import com.example.dto.CarResponseDto;
import com.example.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<List<CarResponseDto>> getCars(@RequestBody CarRequestDto carRequestDto) {
        List<CarResponseDto> availableCars = carService.findAllAvailableCars(carRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }
/*
    @PostMapping("/updatePrice")
    public ResponseEntity<?> updatePriceOfAvailableCars(@RequestBody CarRequestDto carRequestDto, @RequestParam String currency) {
        List<CarResponseDto> availableCars = carService.findAllAvailableCars(carRequestDto);
        for (CarResponseDto car : availableCars) {
            System.out.println("update PRice");

            CurrencyConverterClient currencyConverter = new CurrencyConverterClient("localhost", 5120);

            double convertedPrice = currencyConverter.convertCurrency(carRequestDto.getCarPrice(), "USD", currency);
            car.setPrices((float) convertedPrice);



        }
        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }
    */


}
