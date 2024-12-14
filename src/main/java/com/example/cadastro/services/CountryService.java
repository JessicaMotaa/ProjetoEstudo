package com.example.cadastro.services;

import com.example.cadastro.entitys.Countries;
import com.example.cadastro.entitys.DataResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private List<Countries> countries;

    @PostConstruct
    public void init() {
        loadCountries();
    }
    @Cacheable("countries")
    public List<Countries> getAllCountries() {
        if (countries == null || countries.isEmpty()) {
            loadCountries();
        }
        return countries;
    }

    public List<Countries> getCitiesByCountry(String countryName) {
        return getAllCountries().stream()
                .filter(c -> c.getCountry().trim().equalsIgnoreCase(countryName))
                .collect(Collectors.toList());
    }

    private void loadCountries() {
        try {
            String uri = "https://countriesnow.space/api/v0.1/countries";
            RestTemplate template = new RestTemplate();
            ObjectMapper objectMapper = new ObjectMapper();

            Object response = template.getForObject(uri, Object.class);
            DataResponse dataResponse = objectMapper.convertValue(response, DataResponse.class);
            this.countries = dataResponse.getData();
        } catch (Exception e) {
            e.printStackTrace();
            this.countries = new ArrayList<>();
        }
    }
}
