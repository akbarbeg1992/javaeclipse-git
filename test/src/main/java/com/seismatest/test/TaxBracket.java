package com.seismatest.test;

public class TaxBracket {
	
	private int taxThreshold;
	private int previousTax;
	private double taxRate;
	
	public TaxBracket() {
		super();
	}
	
	public TaxBracket(int taxThreshold, int previousTax, double taxRate) {
		super();
		this.taxThreshold = taxThreshold;
		this.previousTax = previousTax;
		this.taxRate = taxRate;
	}

	public TaxBracket getTaxBracketIfIncomeMatchesThreshold( int annualSalary ) {
		if ( annualSalary > this.taxThreshold )
			return new TaxBracket( this.taxThreshold, this.previousTax, this.taxRate );
		return null;
	}
	
	public int getTaxThreshold() {
		return taxThreshold;
	}
	public void setTaxThreshold(int taxThreshold) {
		this.taxThreshold = taxThreshold;
	}
	public int getPreviousTax() {
		return previousTax;
	}
	public void setPreviousTax(int previousTax) {
		this.previousTax = previousTax;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}	

}
