package com.giri.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FliteringController {
	
	

	@GetMapping("/filter")
	public MappingJacksonValue flitering()
	{
		SomeBean somebean = new SomeBean("Value1", "Value2", "Value3");
		MappingJacksonValue mappingjackson = new MappingJacksonValue(somebean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingjackson.setFilters(filters);
		
		
		
		return mappingjackson;
		
	}
	
	@GetMapping("/filter1")
	public MappingJacksonValue fliteringlist()
	{
		List<SomeBean> list = Arrays.asList(new SomeBean("Value1", "Value2", "Value3"),
				new SomeBean("Value4", "Value5", "Value6"));
		MappingJacksonValue mappingjackson = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingjackson.setFilters(filters);
		
		
		
		return mappingjackson;
		
	}

}
