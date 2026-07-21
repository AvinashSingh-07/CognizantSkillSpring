
package com.cognizant.spring_learn.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.model.Countries;
import com.cognizant.spring_learn.model.Country;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

@Service
public class CountryService {

    public Country getCountry(String code) {

        try {

            JAXBContext context = JAXBContext.newInstance(Countries.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            InputStream is = getClass().getClassLoader().getResourceAsStream("country.xml");

            Countries countries = (Countries) unmarshaller.unmarshal(is);

            List<Country> countryList = countries.getCountryList();

            for (Country country : countryList) {

                if (country.getCode().equalsIgnoreCase(code)) {
                    return country;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}