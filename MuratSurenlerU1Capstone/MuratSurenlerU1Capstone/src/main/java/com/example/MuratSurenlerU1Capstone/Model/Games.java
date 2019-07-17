package com.example.MuratSurenlerU1Capstone.Model;

import java.math.BigDecimal;
import java.util.Objects;

public class Games {
    private int id;
    private String title;
    private String ersbRating;
    private String description;
    private BigDecimal price;
    private String studio;
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
        Games that = (Games) o;
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
