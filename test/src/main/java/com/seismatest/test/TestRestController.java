package com.seismatest.test;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	
	@PostMapping ( 
		value = "/runApp", 
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	)
	  
	public ArrayList<PaySlip> runApplication( @RequestBody ArrayList<Employee> employees ) {
		TestController testController = new TestController( employees );
		return testController.getPaySlips(); 
	}
}
