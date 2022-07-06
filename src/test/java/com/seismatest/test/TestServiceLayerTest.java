package com.seismatest.test;

import java.util.NavigableMap;
import java.util.TreeMap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class TestServiceLayerTest {
	
	
	private Employee testEmployee;
	private TestServiceLayer testTestServiceLayer;
	
	private NavigableMap<Integer, Integer> prevTax = new TreeMap<Integer, Integer>();
	private NavigableMap<Integer, Double> taxBracket = new TreeMap<Integer, Double>();
	
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
	
	

	@BeforeAll
	void setUp() throws Exception {
		this.initializeTaxBracketData();
	}
	
	
	
	
	//Test to ensure firstName and lastName are combined properly
	//Test for Employee with firstName = "Test", lastName= "User"
	@Test
	void testName() {
		this.testEmployee = new Employee( "Test", "User", 60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getName()).isEqualTo( "Test User" );
	}	
	
	
	
	
	//Tests to ensure incomeTax is calculated properly for all conditions
	//Test for positive income value
	@Test
	void testIncomeTax() {
		this.testEmployee = new Employee( "Test", "User", 60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getIncomeTax()).isEqualTo( 922 );
	}
	
	//Test for positive income value
	@Test
	void testIncomeTax2() {
		this.testEmployee = new Employee( "Test", "User", 120000, 0.1f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getIncomeTax()).isEqualTo( 2669 );
	}
	
	//Test when income is 0
	@Test
	void testIncomeTaxWhenIncomeIsZero() {
		this.testEmployee = new Employee( "Test", "User", 0, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getIncomeTax()).isEqualTo( 0 );
	}
	
	//Test when income is negative
	@Test
	void testIncomeTaxWhenIncomeIsNegative() {
		this.testEmployee = new Employee( "Test", "User", -60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getIncomeTax()).isEqualTo( 0 );
	}
	
	
	
	
	//Tests to ensure grossIncome is calculated properly for all conditions
	//Test for positive income value
	@Test
	void testGrossIncome() {
		this.testEmployee = new Employee( "Test", "User", 60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getGrossIncome()).isEqualTo( 5004 );
	}
	
	//Test for positive income value
	@Test
	void testGrossIncome2() {
		this.testEmployee = new Employee( "Test", "User", 120000, 0.1f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getGrossIncome()).isEqualTo( 10000 );
	}
	
	//Test when income is 0
	@Test
	void testGrossIncomeWhenIncomeIsZero() {
		this.testEmployee = new Employee( "Test", "User", 0, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getGrossIncome()).isEqualTo( 0 );
	}
	
	//Test when income is negative
	@Test
	void testGrossIncomeWhenIncomeIsNegative() {
		this.testEmployee = new Employee( "Test", "User", -60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getGrossIncome()).isEqualTo( -5004 );
	}
	
	
	
	
	//Tests to ensure netIncome is calculated properly for all conditions
	//Test for positive income value
	@Test
	void testNetIncome() {
		this.testEmployee = new Employee( "Test", "User", 60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getNetIncome()).isEqualTo( 4082 );
	}
	
	@Test
	void testNetIncome2() {
		this.testEmployee = new Employee( "Test", "User", 120000, 0.1f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getNetIncome()).isEqualTo( 7331 );
	}
	
	//Test when income is 0
	@Test
	void testNetIncomeWhenIncomeIsZero() {
		this.testEmployee = new Employee( "Test", "User", 0, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getNetIncome()).isEqualTo( 0 );
	}
	
	//Test when income is negative
	@Test
	void testNetIncomeWhenIncomeIsNegative() {
		this.testEmployee = new Employee( "Test", "User", -60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getNetIncome()).isEqualTo( -5004 );
	}
	
	
	
	
	//Tests to ensure empSuper is calculated properly for all conditions
	//Test for positive income value	
	@Test
	void testEmpSuper() {
		this.testEmployee = new Employee( "Test", "User", 60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getEmpSuper()).isEqualTo( 450 );
	}
	
	@Test
	void testEmpSuper2() {
		this.testEmployee = new Employee( "Test", "User", 120000, 0.1f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getEmpSuper()).isEqualTo( 1000 );
	}
	
	//Test Test when income is 0	
	@Test
	void testEmpSuperWhenIncomeIsZero() {
		this.testEmployee = new Employee( "Test", "User", 0, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getEmpSuper()).isEqualTo( 0 );
	}
	
	//Test when income is negative
	@Test
	void testEmpSuperWhenIncomeIsNegative() {
		this.testEmployee = new Employee( "Test", "User", -60050, 0.09f, 0 );
		this.testTestServiceLayer = new TestServiceLayer(testEmployee, prevTax, taxBracket);
		this.testTestServiceLayer.createPaySlip();
		PaySlip testPaySlip = this.testTestServiceLayer.getPaySlip();
		
		Assertions.assertThat(testPaySlip.getEmpSuper()).isEqualTo( 0 );
	}
}
