package com.seismatest.test;

import java.util.NavigableMap;
import java.util.TreeMap;


public class TestController {

	private Employee employee;
	private PaySlip paySlip;
	
	private double incomeTax;
	private int prevTaxValue;
	private double taxBracketValue;
	private int taxBracketKey;
	
	private final NavigableMap<Integer, Integer> prevTax = new TreeMap<Integer, Integer>();
	private final NavigableMap<Integer, Double> taxBracket = new TreeMap<Integer, Double>();
	
	
	public TestController( Employee employee ) {
		super();
		this.employee = employee;
		this.paySlip = new PaySlip( employee );
		this.initializeTaxBracketData();
		this.determineTaxBracket();
		this.calculateTax();
		this.createPaySlip();
	}

	private void determineTaxBracket() {
		this.prevTaxValue = this.prevTax.floorEntry( this.employee.getAnnualSalary() ).getValue();
		
		this.taxBracketValue = this.taxBracket.floorEntry( this.employee.getAnnualSalary() ).getValue();
		this.taxBracketKey = this.taxBracket.floorEntry( this.employee.getAnnualSalary() ).getKey() - 1;
	}

	private void calculateTax() {
		this.incomeTax = Math.round( ( this.prevTaxValue + ( this.employee.getAnnualSalary() - this.taxBracketKey ) * this.taxBracketValue ) / 12 );
	}
	
	private void createPaySlip() {
		this.paySlip.setName( this.employee.getFirstName() + " " + this.employee.getLastName() );
		
		this.paySlip.setIncomeTax( this.incomeTax );
		
		this.paySlip.setGrossIncome(  Math.round( this.employee.getAnnualSalary() / 12 ) );
		
		this.paySlip.setNetIncome( (int) ( this.paySlip.getGrossIncome() - this.paySlip.getIncomeTax() ) );
		
		this.paySlip.setEmpSuper( Math.round( this.paySlip.getGrossIncome() * this.employee.getSuperRate() ) );
	}
	
	private void initializeTaxBracketData() {
		this.prevTax.put(0, 0);
		this.prevTax.put(37001, 3572);
		this.prevTax.put(87001, 19822);
		this.prevTax.put(180001, 54232);
		
		this.taxBracket.put(0, 0.0);
		this.taxBracket.put(18201, 0.19);
		this.taxBracket.put(37001, 0.325);
		this.taxBracket.put(87001, 0.37);
		this.taxBracket.put(180001, 0.45);
	}


	public PaySlip getPaySlip() {
		return paySlip;
	}

}
