package com.seismatest.test;

public class Employee {
	private String firstName;
	private String lastName;
	private int annualSalary;
	private float superRate;
	private int paymentStartDate;
	
	
	
	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, int annualSalary, float superRate, int paymentStartDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
		this.superRate = superRate;
		this.paymentStartDate = paymentStartDate;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	public float getSuperRate() {
		return superRate;
	}
	public void setSuperRate(float superRate) {
		this.superRate = superRate;
	}
	public int getPaymentStartDate() {
		return paymentStartDate;
	}
	public void setPaymentStartDate(int paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
	
}
