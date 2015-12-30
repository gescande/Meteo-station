package meteoSpringBoot.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import meteoSpringBoot.persistance.WeatherDirectory;
import meteoSpringBoot.weatherStatement.Humidity;
import meteoSpringBoot.weatherStatement.Luminosity;
import meteoSpringBoot.weatherStatement.Temperature;
import meteoSpringBoot.weatherStatement.Weather;

@Controller
@RequestMapping(value = "/")
class WeatherController
{
    @Autowired
    private WeatherDirectory weatherDirectory;

    @RequestMapping(method = {RequestMethod.GET})
    String home(Model model)
    {
        List<Weather> weatherList = weatherDirectory.findAll();

        Collections.sort(weatherList);


        if (weatherList.size()!= 0)
        {
            Humidity hum = weatherList.get(weatherList.size()-1).getHumidity();
            Luminosity lum = weatherList.get(weatherList.size()-1).getLuminosity();
            Temperature temp = weatherList.get(weatherList.size()-1).getTemperature();

            model.addAttribute("humidity", hum);
            model.addAttribute("luminosity", lum);
            model.addAttribute("temperature", temp);
        }

        return "home";
    }

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    String all(Model model) {
        List<Weather> weatherList = weatherDirectory.findAll();
        Collections.sort(weatherList);

        model.addAttribute("weathers", weatherList);

        return "all";
    }

    @RequestMapping(method = {RequestMethod.POST})
    ResponseEntity<?> store(@RequestBody String json)
    {
        Weather weather = new Weather();
        try
        {
            weather = new ObjectMapper().readValue(json, Weather.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        weatherDirectory.save(weather);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


}
