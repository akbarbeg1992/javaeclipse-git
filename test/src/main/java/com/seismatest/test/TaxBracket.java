package com.seismatest.test;

public class TaxBracket {
	
	private int income;
	private int previousTax;
	private double taxRate;
	
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
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
