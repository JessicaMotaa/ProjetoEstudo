package com.example.cadastro.controllers;

import com.example.cadastro.entitys.Countries;
import com.example.cadastro.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    private final CountryService countryService;

    public CityController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Countries> getCountryDetails() {
        return countryService.getAllCountries();
    }

    @GetMapping("/city")
    public List<Countries> getCity(@RequestParam String countryName) {
        return countryService.getCitiesByCountry(countryName);
    }
}
