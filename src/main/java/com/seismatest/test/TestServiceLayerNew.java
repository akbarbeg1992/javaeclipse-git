package com.seismatest.test;

import java.util.List;
import java.util.Optional;

public class TestServiceLayerNew {
	
	private List<TaxBracket> taxBrackets;
	
	private Employee employee;
	private PaySlip paySlip;
	
	private TaxBracket taxBracket;
	private long incomeTax;
	
	
	public TestServiceLayerNew(List<TaxBracket> taxBrackets, Employee employee) {
		super();
		this.taxBrackets = taxBrackets;
		this.employee = employee;
		this.paySlip = new PaySlip( employee );
	}
	
	public void determineTaxBracket() {
		if ( this.employee.getAnnualSalary() > 0 ) {
			Optional<TaxBracket> taxBracket = this.taxBrackets.stream()
												.map( t -> t.getTaxBracketIfIncomeMatchesThreshold( this.employee.getAnnualSalary() ) )
												.filter( t -> t != null )
												.findFirst();
			this.taxBracket = taxBracket.get();
		} else {
			this.taxBracket = new TaxBracket( 0, 0, 0 );
		}	
	}
	
	private void calculateTax() {
		this.incomeTax = Math.round( ( this.taxBracket.getPreviousTax() + ( this.employee.getAnnualSalary() - this.taxBracket.getTaxThreshold() ) * this.taxBracket.getTaxRate() ) / 12.0 );
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
