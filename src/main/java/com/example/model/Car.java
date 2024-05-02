package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.List;

@Document("cars")
public class Car {

    @Id
    private String id;

    @Field("brandName")
    private String brand;

    @Field("modelName")
    private String model;

    private int numberOfSeats;

    private BigDecimal price;

    private List<BookingPeriod> bookings;

    public Car() {}

    public Car(String brand, String model, int numberOfSeats, BigDecimal price, List<BookingPeriod> bookings) {
        this.brand = brand;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.bookings = bookings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<BookingPeriod> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingPeriod> bookings) {
        this.bookings = bookings;
    }
}
