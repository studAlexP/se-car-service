package com.example.service;

import com.example.dto.BookingRequestDto;
import com.example.model.BookingPeriod;
import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingEventListener {

    private final CarRepository carRepository;

    public BookingEventListener(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @KafkaListener(topics = "booking-update", groupId = "car-service-group")
    public void listenForBookingEvent(BookingRequestDto bookingRequestDto) {
        BookingPeriod bookingPeriod = new BookingPeriod();
        bookingPeriod.setPickupDate(bookingRequestDto.getPickupDate());
        bookingPeriod.setReturnDate(bookingRequestDto.getReturnDate());
        updateCarAvailability(bookingRequestDto.getCardId(), bookingPeriod);
    }

    private void updateCarAvailability(long carId, BookingPeriod bookingPeriod) {
        Optional<Car> carById = carRepository.findById(String.valueOf(carId));
        if (carById.isPresent()) {
            Car car = carById.get();
            List<BookingPeriod> bookings = car.getBookings();

            boolean bookingExists = false;

            for(BookingPeriod bp : bookings) {
                if (bp.getPickupDate().equals(bookingPeriod.getPickupDate()) &&
                        bp.getReturnDate().equals(bookingPeriod.getReturnDate())) {
                    bookingExists = true;
                    bookings.remove(bp);
                    break;
                }
            }

            if (!bookingExists) {
                bookings.add(bookingPeriod);
            }

            car.setBookings(bookings);
            carRepository.save(car);
        }
    }
}
