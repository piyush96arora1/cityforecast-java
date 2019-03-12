package com.java.forecast.CityForecast.Hiring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.forecast.CityForecast.Hiring.entity.WeatherResponse;
@Repository
public interface WeatherRepo extends CrudRepository<WeatherResponse, Long> {
	@Query("select w from  WeatherResponse w ")
	public List<WeatherResponse> findAll();
}
