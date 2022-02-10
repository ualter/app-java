package com.allianz.cloud.sre.app.controller;

import java.util.List;

import com.allianz.cloud.sre.app.service.CityService;
import com.allianz.cloud.sre.app.vo.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@Autowired
    private CityService cityService;

	@GetMapping("/city")
	public List<City> listCities() {
		return cityService.getCities();
	}

	@GetMapping("/city/{id}")
	public City getCity(@PathVariable Long id) {
		return cityService.getCity(id);
	}
}