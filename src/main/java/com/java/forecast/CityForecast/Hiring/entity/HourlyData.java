package com.java.forecast.CityForecast.Hiring.entity;

import java.util.List;

public class HourlyData {
long dt;
TempratureDetials main;
List<Weather> weather;
String dt_txt;
public long getDt() {
	return dt;
}
public void setDt(long dt) {
	this.dt = dt;
}
public TempratureDetials getMain() {
	return main;
}
public void setMain(TempratureDetials main) {
	this.main = main;
}

public List<Weather> getWeather() {
	return weather;
}
public void setWeather(List<Weather> weather) {
	this.weather = weather;
}
public String getDt_txt() {
	return dt_txt;
}
public void setDt_txt(String dt_txt) {
	this.dt_txt = dt_txt;
}

}


class Weather
{
	long id;
	String main;
	String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
