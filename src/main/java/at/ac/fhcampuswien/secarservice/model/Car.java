package at.ac.fhcampuswien.secarservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("cars")
public class Car {

    @Id
    private long id;

    //@Field("brandName")
    private String brand;

    //@Field("modelName")
    private String model;

    private int numberOfSeats;

    private BigDecimal price;

    public Car() {}

    public Car(String brand, String model, int numberOfSeats, BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
