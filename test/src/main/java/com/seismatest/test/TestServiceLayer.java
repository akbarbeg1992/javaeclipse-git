package com.seismatest.test;

import java.util.NavigableMap;
import java.util.TreeMap;


public class TestServiceLayer {

	private Employee employee;
	private PaySlip paySlip;
	
	private double incomeTax;
	private int prevTaxValue;
	private double taxBracketValue;
	private int taxBracketKey;
	
	private NavigableMap<Integer, Integer> prevTax = new TreeMap<Integer, Integer>();
	private NavigableMap<Integer, Double> taxBracket = new TreeMap<Integer, Double>();
	
	
	public TestServiceLayer( Employee employee, NavigableMap<Integer, Integer> prevTax, NavigableMap<Integer, Double> taxBracket ) {
		super();
		this.employee = employee;
		this.paySlip = new PaySlip( employee );
		this.prevTax = prevTax;
		this.taxBracket = taxBracket;
	}

	private void determineTaxBracket() {
		if ( this.employee.getAnnualSalary() > 0 ) {
			this.prevTaxValue = this.prevTax.floorEntry( this.employee.getAnnualSalary() ).getValue();
			this.taxBracketValue = this.taxBracket.floorEntry( this.employee.getAnnualSalary() ).getValue();
			this.taxBracketKey = this.taxBracket.floorEntry( this.employee.getAnnualSalary() ).getKey() - 1;
		}
		else {
			this.prevTaxValue = 0;
			this.taxBracketValue = 0;
			this.taxBracketKey = 0;
		}
	}

	private void calculateTax() {
		this.incomeTax = Math.round( ( this.prevTaxValue + ( this.employee.getAnnualSalary() - this.taxBracketKey ) * this.taxBracketValue ) / 12.0 );
	}
	
	public void createPaySlip() {
		this.determineTaxBracket();
		this.calculateTax();
		
		this.paySlip.setName( this.employee.getFirstName() + " " + this.employee.getLastName() );
		
		this.paySlip.setIncomeTax( (int) this.incomeTax );
		
		this.paySlip.setGrossIncome(  (int) Math.round( this.employee.getAnnualSalary() / 12.0 ) );
		
		this.paySlip.setNetIncome( (int) ( this.paySlip.getGrossIncome() - this.paySlip.getIncomeTax() ) );
		
		int empSuper =  Math.round( this.paySlip.getGrossIncome() * this.employee.getSuperRate() );
		this.paySlip.setEmpSuper( empSuper > 0 ? empSuper : 0 );
	}

	public PaySlip getPaySlip() {
		return paySlip;
	}
}
