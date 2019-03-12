package com.java.forecast.CityForecast.Hiring.service;


import java.text.ParseException;

import java.util.List;
import java.util.OptionalDouble;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.java.forecast.CityForecast.Hiring.entity.UpWeatherResponse;
import com.java.forecast.CityForecast.Hiring.entity.WeatherResponse;
import com.java.forecast.CityForecast.Hiring.repo.WeatherRepo;

@Component
public class WeatherService {
@Autowired
WeatherRepo repo;

UpWeatherResponse response=new UpWeatherResponse();
	public ResponseEntity<WeatherResponse> getWeatherInfo(Long cityid, HttpServletRequest request,String date1,String date2) throws ParseException {
		
		System.setProperty("https.protocols", "TLSv1.1");
		String url=String.format("http://api.openweathermap.org/data/2.5/forecast?id=%s&appid=9276ac6c6cbae5e1cde2e9fb735cbeeb", cityid);
		
		RestTemplate template=new RestTemplate();
		WeatherResponse queryResponse=new WeatherResponse();
		if(((date1==null&&date2==null)&&cityid==null)||cityid==null)
		{
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		try {
			response=template.getForObject(url,UpWeatherResponse.class );
			OptionalDouble d=	response.getList().stream().map(x->x.getMain().getTemp_max()).mapToDouble(v->v).max();
			if((date1!=null)&&(date2!=null)) {
				if(!date1.isEmpty()&& !date2.isEmpty()) {
			OptionalDouble data=response.getList().stream().filter(x->x.getDt_txt().equals(date1)).map(y->y.getMain().getTemp_max()).mapToDouble(z->z).max();
			OptionalDouble data1=response.getList().stream().filter(x->x.getDt_txt().equals(date2)).map(y->y.getMain().getTemp_max()).mapToDouble(z->z).max();
			double maxTemp;
			if(data1.getAsDouble()>data.getAsDouble())
				maxTemp=data1.getAsDouble();
			else
				maxTemp=data.getAsDouble();
			queryResponse.setMaxTemp(maxTemp);
			queryResponse.setRequest(request.getRequestURI());
			queryResponse.setCityName(response.getCity().getName());
			repo.save(queryResponse);
			return new ResponseEntity<WeatherResponse>(queryResponse,HttpStatus.OK);
			}
			}
			
		
			
			queryResponse.setMaxTemp(d.getAsDouble());
			queryResponse.setRequest(request.getRequestURI());
			queryResponse.setCityName(response.getCity().getName());
			repo.save(queryResponse);

			return new ResponseEntity<WeatherResponse>(queryResponse,HttpStatus.OK);
		}
		catch(Exception e)
		{
	
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		

	
	}

	public List<WeatherResponse> getDB() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
