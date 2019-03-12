package com.java.forecast.CityForecast.Hiring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherResponse {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	long requestId;
	@Column
	String request;
	@Column
	Double maxTemp;
	@Column
	String cityName;
public long getRequestId() {
	return requestId;
}
public void setRequestId(long requestId) {
	this.requestId = requestId;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public String getRequest() {
	return request;
}
public void setRequest(String request) {
	this.request = request;
}
public Double getMaxTemp() {
	return maxTemp;
}
public void setMaxTemp(Double maxTemp) {
	this.maxTemp = maxTemp;
}

}
