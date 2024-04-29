package at.ac.fhcampuswien.secarservice.dto;

import java.math.BigDecimal;

public class CarResponseDto {

    private long id;
    private String brand;
    private String model;
    private int numberOfSeats;
    private BigDecimal price;

    public CarResponseDto() {}

    public CarResponseDto(long id, String brand, String model, int numberOfSeats, BigDecimal price) {
        this.id = id;
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
