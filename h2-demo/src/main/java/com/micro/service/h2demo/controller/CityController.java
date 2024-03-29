package com.micro.service.h2demo.controller;

import com.micro.service.h2demo.CityService;
import com.micro.service.h2demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/city") // This means URL's start with /demo (after Application path)
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody City addNewCity (
            @RequestParam String name,
            @RequestParam String postcode,
            @RequestParam String departement) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        final City city = new City();
        city.setName(name);
        city.setPostcode(postcode);
        city.setDepartement(departement);
        return cityService.save(city);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<City> getAllCities() {
        // This returns a JSON or XML with the users
        return cityService.getAllCities();
    }
}
