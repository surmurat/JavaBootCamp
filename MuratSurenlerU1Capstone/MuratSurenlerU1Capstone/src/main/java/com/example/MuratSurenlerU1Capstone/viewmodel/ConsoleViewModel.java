package com.example.MuratSurenlerU1Capstone.viewmodel;

import com.example.MuratSurenlerU1Capstone.Model.Consoles;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    private int id;
    @NotEmpty(message = "Please supply a value for model")
    private String model;
    @NotEmpty(message = "Please supply a value for manufacturer")
    private String manufacturer;
    @NotEmpty(message = "Please supply a value for memory amount")
    private String memoryAmount;
    @NotEmpty(message = "Please supply a value for processor")
    private String processor;
    @PositiveOrZero(message = "Price must be positive or zero")
    private BigDecimal price;
    @Positive(message = "Quantity must be positive")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getId() == that.getId() &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getManufacturer(), that.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), that.getMemoryAmount()) &&
                Objects.equals(getProcessor(), that.getProcessor()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getQuantity(), that.getQuantity());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }
}
