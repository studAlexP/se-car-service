package com.example.dto;

import java.time.LocalDate;

public class CarRequestDto {

    private LocalDate pickupDate;
    private LocalDate returnDate;

    private float carPrice;

    public CarRequestDto() {}

    public CarRequestDto(LocalDate pickupDate, LocalDate returnDate, float carPrice) {
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.carPrice = carPrice;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }
}
