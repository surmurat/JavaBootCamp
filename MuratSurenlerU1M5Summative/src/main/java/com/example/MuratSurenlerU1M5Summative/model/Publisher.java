package com.example.MuratSurenlerU1M5Summative.model;

import java.util.Objects;

public class Publisher {
    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;

    public Publisher() {
    }

    public Publisher(String name, String street, String city, String state, String postal_code, String phone, String email) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher that = (Publisher) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getStreet(), that.getStreet()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getState(), that.getState()) &&
                Objects.equals(getPostal_code(), that.getPostal_code()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getCity(), getState(), getPostal_code(), getPhone(), getEmail());
    }
}
