package com.fullstack.vehicles.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String manufacturer;
    private String model;
    private String color;
    private LocalDateTime manufacturedAt;

    public Vehicle() {
    }

    public Vehicle(Integer id, String manufacturer, String model, String color, LocalDateTime manufacturedAt) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.manufacturedAt = manufacturedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getManufacturedAt() {
        return manufacturedAt;
    }

    public void setManufacturedAt(LocalDateTime manufacteredAt) {
        this.manufacturedAt = manufacteredAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id.equals(vehicle.id) && Objects.equals(manufacturer, vehicle.manufacturer) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color) && Objects.equals(manufacturedAt, vehicle.manufacturedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
