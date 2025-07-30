package com.day7proj2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("/weather")
public class WeatherController {
    
    @GetMapping("/today")
    public String getweather() {
        return "Today's weather: Sunny, 30°C";
    }

    @GetMapping("/tomorrow")
    public String gettomorrow() {
        return "Tomorrow's forecast: Cloudy with rain";
    }

    @GetMapping("/city/{city}")
    public String getcityweather(@PathVariable String city){
        return "Weather report for "+city+" is currently unavailable.";
    }

}
