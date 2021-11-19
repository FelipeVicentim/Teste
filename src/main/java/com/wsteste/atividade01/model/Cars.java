package com.wsteste.atividade01.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_CARS")
public class Cars implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long car_id;
    @ManyToOne
    @JoinColumn(name = "MARCA_ID")
    private Factories factory_id;
    @Column(name = "MODELO", nullable = false)
    private String car_model;
    @Column(name = "ANO", nullable = false)
    private int car_year;
    @Column(name = "COMBUSTIVEL", nullable = false)
    private String car_fuel;
    @Column(name = "NUM PORTAS", nullable = false)
    private int car_doors;
    @Column(name = "VALOR FIPE", nullable = false)
    private double car_cost;
    @Column(name = "COR", nullable = false)
    private String car_color;

    public Cars(String car_model, int car_year, String car_fuel, int car_doors, double car_cost, String car_color) {

        this.car_model = car_model;
        this.car_year = car_year;
        this.car_fuel = car_fuel;
        this.car_doors = car_doors;
        this.car_cost = car_cost;
        this.car_color = car_color;
    }

    public Cars() {
    }

    public Cars(long car_id, String modelo, int ano, String combustivel, int num_portas, double valor_fipe, String cor) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return car_id == cars.car_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(car_id);
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public int getCar_year() {
        return car_year;
    }

    public void setCar_year(int car_year) {
        this.car_year = car_year;
    }

    public String getCar_fuel() {
        return car_fuel;
    }

    public void setCar_fuel(String car_fuel) {
        this.car_fuel = car_fuel;
    }

    public int getCar_doors() {
        return car_doors;
    }

    public void setCar_doors(int car_doors) {
        this.car_doors = car_doors;
    }

    public double getCar_cost() {
        return car_cost;
    }

    public void setCar_cost(double car_cost) {
        this.car_cost = car_cost;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }


}
