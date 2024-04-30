package at.ac.fhcampuswien.secarservice.controller;

import at.ac.fhcampuswien.secarservice.dto.CarResponseDto;
import at.ac.fhcampuswien.secarservice.model.Car;
import at.ac.fhcampuswien.secarservice.service.CarService;
import at.ac.fhcampuswien.secarservice.dto.CarAvailabilityDto;
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

    @GetMapping
    public ResponseEntity<?> getCars() {
        List<CarResponseDto> availableCars = carService.findAllAvailableCars();
        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }

    @PostMapping
    public ResponseEntity<?> findAvailableCars(@RequestBody CarAvailabilityDto carAvailabilityDto) {
        List<Car> availableCars = carService.findAvailableCars(carAvailabilityDto.getPickupDate(), carAvailabilityDto.getReturnDate());

        return ResponseEntity.status(HttpStatus.OK).body(availableCars);
    }
}
