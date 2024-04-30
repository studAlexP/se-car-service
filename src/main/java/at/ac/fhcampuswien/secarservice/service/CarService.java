package at.ac.fhcampuswien.secarservice.service;

import at.ac.fhcampuswien.secarservice.dto.CarResponseDto;
import at.ac.fhcampuswien.secarservice.model.Car;
import at.ac.fhcampuswien.secarservice.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional(readOnly = true)
    public List<CarResponseDto> findAllAvailableCars() {
        List<Car> availableCars = carRepository.findAll();

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

    public List<Car> findAvailableCars(LocalDate pickupDate, LocalDate returnDate) {
        return carRepository.findAvailableCars(pickupDate, returnDate);
    }
}
