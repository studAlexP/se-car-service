package com.example.service;

import com.example.dto.CarRequestDto;
import com.example.dto.CarResponseDto;
import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional(readOnly = true)
    public List<CarResponseDto> findAllAvailableCars(CarRequestDto carRequestDto) {
        List<Car> availableCars = carRepository.findAvailableCars(carRequestDto.getPickupDate(), carRequestDto.getReturnDate());

        return availableCars.stream()
                .map(this::mapCarToCarResponseDto)
                .collect(Collectors.toList());
    }

    private CarResponseDto mapCarToCarResponseDto (Car car) {
        return new CarResponseDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getNumberOfSeats(),
                car.getPrice()
        );
    }
}
