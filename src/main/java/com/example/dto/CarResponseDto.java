package com.example.dto;

import java.math.BigDecimal;

public class CarResponseDto {

    private String id;
    private String brand;
    private String model;
    private int numberOfSeats;
    private BigDecimal price;

    public CarResponseDto() {}

    public CarResponseDto(String id, String brand, String model, int numberOfSeats, BigDecimal price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
