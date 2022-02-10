package com.allianz.cloud.sre.app.service;

import java.util.ArrayList;
import java.util.List;

import com.allianz.cloud.sre.app.vo.City;

import org.springframework.stereotype.Service;

@Service
public class MockCityRepository {

    public List<City> getCityRepo() {
        List<City> cities = new ArrayList<>();

        cities.add(new City(1L, "Paris", 432000));
        cities.add(new City(2L, "Barcelona", 1759000));
        cities.add(new City(3L, "Roma", 1280000));
        cities.add(new City(4L, "Warsaw", 1748000));
        cities.add(new City(5L, "Los Angeles", 3971000));
        cities.add(new City(6L, "New York", 8550000));
        cities.add(new City(7L, "Edinburgh", 464000));
        cities.add(new City(8L, "Berlin", 3671000));
        cities.add(new City(9L, "Frankfurt", 4121000));

        return cities;
    }
    
}
