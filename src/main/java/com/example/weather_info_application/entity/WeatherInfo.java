package com.example.weather_info_application.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "weatherInfo")
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String pinCode;

    private LocalDate date;

    @Column(unique = true)
    private String cityName;

    private Sys sys;

    private Coordinate coord;

    @ElementCollection
    private List<Weather> weather;

    @Embedded
    private Main main;

    private Wind wind;

    @Embeddable
    public static class Sys {

        private String country;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    @Embeddable
    public static class Weather {
        private int id;
        private String description;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    @Embeddable
    public static class Main {
        private double temp;
        private int humidity;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    @Embeddable
    public static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }

    @Embeddable
    public static class Coordinate {
        private double lon;
        private double lat;

        public double getLon(){
            return lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
    }
}
