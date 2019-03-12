package com.java.forecast.CityForecast.Hiring.entity;

import java.util.List;

public class UpWeatherResponse {
String cod;
float message;
int cnt;
List<HourlyData> list;
City city;
public String getCod() {
	return cod;
}
public void setCod(String cod) {
	this.cod = cod;
}
public float getMessage() {
	return message;
}
public void setMessage(float message) {
	this.message = message;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
public List<HourlyData> getList() {
	return list;
}
public void setList(List<HourlyData> list) {
	this.list = list;
}
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}

}
