package com.seismatest.test;

import java.util.ArrayList;

public class TestView {
	private ArrayList<Employee> employees;
	private ArrayList<PaySlip> paySlips;
	private TestController testController;
	
	public TestView( ArrayList<Employee> employees ) {
		this.employees = employees;
		this.paySlips = new ArrayList<PaySlip>();
		this.generatePaySlips();
	}
	
	private void generatePaySlips() {
		
		for ( Employee employee : this.employees ) {
			this.testController = new TestController( employee );
			this.paySlips.add( this.testController.getPaySlip() );
		}
	}
	
	public ArrayList<PaySlip> getPaySlips() {
		return this.paySlips;
	}
	
}
