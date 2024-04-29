package at.ac.fhcampuswien.secarservice.controller;

import at.ac.fhcampuswien.secarservice.dto.CarResponseDto;
import at.ac.fhcampuswien.secarservice.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<?> getCars() {
        List<CarResponseDto> availableCars = carService.findAllAvailableCars();
        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }
}
