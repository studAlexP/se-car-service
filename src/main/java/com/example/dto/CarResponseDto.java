package com.example.dto;

import java.math.BigDecimal;

public class CarResponseDto {

    private String id;
    private String brandName;
    private String modelName;
    private int numberOfSeats;
    private BigDecimal price;

    public CarResponseDto() {}

    public CarResponseDto(String id, String brandName, String modelName, int numberOfSeats, BigDecimal price) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPrices(float convertedPrice) {
    }
}
