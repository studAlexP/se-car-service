package com.example.repository;

import com.example.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    @Query("{ 'bookings': { $not: { $elemMatch: { pickupDate: { $lt: ?1 }, returnDate: { $gt: ?0 } } } } }")
    List<Car> findAvailableCars(LocalDate pickupDate, LocalDate returnDate);
}
