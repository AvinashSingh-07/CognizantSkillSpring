package com.cognizant.springlearn.service;

import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CountryService {

    private final Map<String, String> countries = new LinkedHashMap<>();

    public CountryService() {
        countries.put("in", "India");
        countries.put("us", "United States");
        countries.put("uk", "United Kingdom");
    }

    public String getCountry(String countryCode) {
        if (!countries.containsKey(countryCode)) {
            throw new CountryNotFoundException();
        }
        return countries.get(countryCode);
    }
}
