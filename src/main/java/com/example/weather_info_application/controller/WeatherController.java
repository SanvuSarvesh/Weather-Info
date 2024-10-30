package com.example.weather_info_application.controller;

import com.example.weather_info_application.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    @GetMapping("weather/api/{pinoCode}")
    public Object getWeatherInfo(@PathVariable("pinoCode") String pinoCode){
        long currentTime = System.currentTimeMillis();
        LOGGER.info("Inside the Class : WeatherController, method : getWeatherInfo");
        Object response = weatherService.getWeatherInfo("001122");
        LOGGER.info("Time taken by the api : "+(System.currentTimeMillis()-currentTime)+" : response : "+response);
        return response;
    }

    @GetMapping("weather/api/{pinoCode}/{date}")
    public Object findWeatherInfoByPinCodeAndDate(@PathVariable("pinoCode") String pinoCode, @PathVariable("date")LocalDate date){
        long currentTime = System.currentTimeMillis();
        LOGGER.info("Inside the Class : WeatherController, method : findWeatherInfoByPinCodeAndDate");
        Object response = weatherService.findWeatherInfoByPinCodeAndDate(pinoCode,date);
        LOGGER.info("Response of the API is : "+response);
        return response;
    }

    @GetMapping
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}
