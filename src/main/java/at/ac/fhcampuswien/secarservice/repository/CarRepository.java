package at.ac.fhcampuswien.secarservice.repository;

import at.ac.fhcampuswien.secarservice.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    @Query("{ 'id': { '$nin': [ ?0 ] } }")
    List<Car> findAvailableCars(LocalDate pickupDate, LocalDate returnDate);
}
