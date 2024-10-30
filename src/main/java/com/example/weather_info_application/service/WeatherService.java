package com.example.weather_info_application.service;

import com.example.weather_info_application.entity.WeatherData;
import com.example.weather_info_application.entity.WeatherInfo;
import com.example.weather_info_application.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.*;

@Service
public class WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${geo.api.key}")
    private String geoApiKey;
    private static final String city = "Patna";


    public Object getWeatherInfo(String pincode){
        LOGGER.info("Inside the Class : WeatherService, method : getWeatherInfo");
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        //RestTemplate restTemplate = new RestTemplate();
        WeatherInfo weatherResponse = new WeatherInfo();
        try {
            weatherResponse = restTemplate.getForObject(url, WeatherInfo.class);
        }catch (Exception exception){
            exception.getMessage();
            LOGGER.error("Inside the Class : WeatherService, method : getWeatherInfo : error : "+exception.getMessage());
        }

        LocalDate localDate = LocalDate.now();
        weatherResponse.setDate(localDate);
        weatherResponse.setCityName(city);

        WeatherData weatherData = new WeatherData();
        weatherData.setLon(weatherResponse.getCoord().getLon());
        weatherData.setLat(weatherResponse.getCoord().getLat());
        weatherData.setCity(weatherResponse.getCityName());
        weatherData.setDate(weatherResponse.getDate());
        weatherData.setPinCode(pincode);
        weatherData.setTemp(weatherResponse.getMain().getTemp());
        weatherData.setHumidity(weatherResponse.getMain().getHumidity());

        weatherRepository.save(weatherData);

        return weatherResponse;
    }

    public Object findWeatherInfoByPinCodeAndDate(String pincode, LocalDate date) {

        Optional<WeatherData> response = weatherRepository.findByPinCodeAndDate(pincode,date);
        if(!Objects.isNull(response)){
            return response.get();
        }
        return "No Such Information with the Given Pincode and Date";
    }

    public String findCity(String pincode){
        return "";
    }

}

// https://api.openweathermap.org/data/2.5/weather?lat=25.6&lon=85.1167&appid={API key}
