package com.seismatest.test;

public class PaySlip {
	private String name;
	private int payPeriod;
	private int grossIncome;
	private int incomeTax;
	private int netIncome;
	private int empSuper;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(int payPeriod) {
		this.payPeriod = payPeriod;
	}
	public int getGrossIncome() {
		return grossIncome;
	}
	public void setGrossIncome(int grossIncome) {
		this.grossIncome = grossIncome;
	}
	public int getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = (int) incomeTax;
	}
	public int getNetIncome() {
		return netIncome;
	}
	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}
	public int getEmpSuper() {
		return empSuper;
	}
	public void setEmpSuper(int empSuper) {
		this.empSuper = empSuper;
	}
	
}
