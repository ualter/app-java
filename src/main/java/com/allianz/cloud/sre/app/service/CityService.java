package com.allianz.cloud.sre.app.service;

import java.util.List;
import java.util.stream.IntStream;

import com.allianz.cloud.sre.app.vo.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private MockCityRepository cityRepository;

    public List<City> getCities() {
        return cityRepository.getCityRepo();
    }
    
    public City getCity(Long id) {
        List<City> listCities = cityRepository.getCityRepo();
        
        int index = IntStream.range(0, listCities.size())
         .filter(i -> listCities.get(i).getId() == id)
         .findFirst()
         .orElse(-1);

        if (index > -1) {
            return listCities.get(index);
        }
        return null;
    }
}
