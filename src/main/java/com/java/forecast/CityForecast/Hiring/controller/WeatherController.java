package com.java.forecast.CityForecast.Hiring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.forecast.CityForecast.Hiring.entity.WeatherRequestBody;
import com.java.forecast.CityForecast.Hiring.entity.WeatherResponse;
import com.java.forecast.CityForecast.Hiring.service.WeatherService;

@RestController
@RequestMapping("")
public class WeatherController {

	@Autowired
	WeatherService service;

	@PostMapping("/getWeatherInfo")
	public ResponseEntity<WeatherResponse> weatherDetails(HttpServletRequest request,
			@RequestBody WeatherRequestBody acceptedDates) throws Exception {
		return service.getWeatherInfo(acceptedDates.getCityId(), request, acceptedDates.getDate1(),
				acceptedDates.getDate2());

	}

	@GetMapping("/weatherMappedWithRequest")
	public ResponseEntity<List<WeatherResponse>> getDB() {
		List<WeatherResponse> response = service.getDB();
		return new ResponseEntity<List<WeatherResponse>>(response, HttpStatus.OK);
	}

}
