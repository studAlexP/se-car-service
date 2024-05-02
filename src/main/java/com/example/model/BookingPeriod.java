package com.example.model;

import java.time.LocalDate;

public class BookingPeriod {

    private LocalDate pickupDate;
    private LocalDate returnDate;

    public BookingPeriod() {}

    public BookingPeriod(LocalDate pickupDate, LocalDate returnDate) {
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
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
}
