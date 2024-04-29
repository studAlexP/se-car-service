package at.ac.fhcampuswien.secarservice.repository;

import at.ac.fhcampuswien.secarservice.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    @Query("{ 'id': { '$nin': [ ?0 ] } }")
    List<Car> findAvailableCars(Locale pickupDate, LocalDate returnDate);
}
