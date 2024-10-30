package com.example.weather_info_application.repository;

import com.example.weather_info_application.entity.WeatherData;
import com.example.weather_info_application.entity.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData,Integer> {

    Optional<WeatherData> findByPinCodeAndDate(String pinCode, LocalDate date);
}
