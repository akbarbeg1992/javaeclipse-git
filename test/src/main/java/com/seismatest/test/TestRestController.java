package com.seismatest.test;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	@RequestMapping (
		value = "/runApp",
		method = RequestMethod.POST,
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	)
	
	@ResponseBody
	public ArrayList<PaySlip> runApplication( @RequestBody ArrayList<Employee> employees ) {
		TestView testView = new TestView( employees );
		return testView.getPaySlips();
	}
}
