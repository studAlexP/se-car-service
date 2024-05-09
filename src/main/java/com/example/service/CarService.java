package com.example.service;

import com.example.currencyConverter.CurrencyConverterClient;
import com.example.dto.CarResponseDto;
import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional(readOnly = true)
    public List<CarResponseDto> getAvailableCars(LocalDate pickupDate, LocalDate returnDate) {
        List<Car> availableCars = carRepository.findAvailableCars(pickupDate, returnDate);

        return availableCars.stream()
                .map(this::mapCarToCarResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CarResponseDto> getAvailableCars(LocalDate pickupDate, LocalDate returnDate, String toCurrency) {
        final CurrencyConverterClient currencyConverter = new CurrencyConverterClient("localhost", 9999);
        List<Car> availableCars = carRepository.findAvailableCars(pickupDate, returnDate);

        return availableCars.stream()
                .map(car -> {
                    CarResponseDto carResponseDto = mapCarToCarResponseDto(car);

                    double originalPrice = car.getPrice().doubleValue();
                    double convertedPrice = currencyConverter.convertCurrency(originalPrice, "USD", toCurrency);
                    carResponseDto.setPrice(new BigDecimal(convertedPrice));

                    return carResponseDto;
                })
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CarResponseDto getCarById(String id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isEmpty()) {
            throw new RuntimeException("Car not found");
        }

        return mapCarToCarResponseDto(car.get());
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
