package com.example.MuratSurenlerU1Capstone.viewmodel;

import com.example.MuratSurenlerU1Capstone.Model.Games;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

public class GamesViewModel {
    private int id;
    @NotEmpty(message = "Please supply a value for title")
    private String title;
    @NotEmpty(message = "Please supply a value for ersb rating")
    private String ersbRating;
    @NotEmpty(message = "Please supply a value for description")
    private String description;
    @PositiveOrZero(message = "Price must be positive or 0")
    private BigDecimal price;
    @NotEmpty(message = "Please supply a value for studio")
    private String studio;
    @Positive(message = "Quantity must be positive")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getErsbRating() {
        return ersbRating;
    }

    public void setErsbRating(String ersbRating) {
        this.ersbRating = ersbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        GamesViewModel that = (GamesViewModel) o;
        return getId() == that.getId() &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getErsbRating(), that.getErsbRating()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getStudio(), that.getStudio()) &&
                Objects.equals(getQuantity(), that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getErsbRating(), getDescription(), getPrice(),getStudio(), getQuantity());
    }
}
