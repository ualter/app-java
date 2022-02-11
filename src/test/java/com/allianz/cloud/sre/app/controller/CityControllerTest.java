package com.allianz.cloud.sre.app.controller;

import java.util.List;

import com.allianz.cloud.sre.app.service.CityService;
import com.allianz.cloud.sre.app.service.MockCityRepository;
import com.allianz.cloud.sre.app.vo.City;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CityController.class)
public class CityControllerTest {

    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private CityService cityService;

	@Test
	public void retrieveAllCities() throws Exception {
		List<City> listCities = this.getMockData();
		
		Mockito.when(cityService.getCities()).thenReturn(listCities);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/city").accept(MediaType.APPLICATION_JSON);

		String expectedResult = "[{\"id\":1,\"name\":\"Paris\",\"population\":432000},{\"id\":2,\"name\":\"Barcelona\",\"population\":1759000},{\"id\":3,\"name\":\"Roma\",\"population\":1280000},{\"id\":4,\"name\":\"Warsaw\",\"population\":1748000},{\"id\":5,\"name\":\"Los Angeles\",\"population\":3971000},{\"id\":6,\"name\":\"New York\",\"population\":8550000},{\"id\":7,\"name\":\"Edinburgh\",\"population\":464000},{\"id\":8,\"name\":\"Berlin\",\"population\":3671000},{\"id\":9,\"name\":\"Frankfurt\",\"population\":4121000}]";

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("\n>>------>");
		System.out.println(result.getResponse().getContentAsString());
		System.out.println("<<------<<\n");

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void retrieveOneCity() throws Exception {
		List<City> listCities = this.getMockData();
		
		Mockito.when(cityService.getCity(2L)).thenReturn(listCities.get(1));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/city/{id}", 2L).accept(MediaType.APPLICATION_JSON);

		String expectedResult = "{\"id\":2,\"name\":\"Barcelona\",\"population\":1759000}";

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("\n>>------>");
		System.out.println(result.getResponse().getContentAsString());
		System.out.println("<<------<<\n");

		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
    
	private List<City> getMockData() {
		//Using the mock for mock :-)
		MockCityRepository mockCityRepository = new MockCityRepository();
		return mockCityRepository.getCityRepo();
	}
    
    
}
