package com.example.weather_info_application.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String pinCode;

    private LocalDate date;

    @Column(unique = true)
    private String city;

    private double temp;

    private double humidity;

    private double lat;

    private double lon;
}
