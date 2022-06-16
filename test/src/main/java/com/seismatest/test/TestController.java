package com.seismatest.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestController {
	private final String TAX_FILE = "/data/taxBracketData.json";
	private final NavigableMap<Integer, Integer> prevTax = new TreeMap<Integer, Integer>();
	private final NavigableMap<Integer, Double> taxBracket = new TreeMap<Integer, Double>();
	
	private ArrayList<Employee> employees;
	private ArrayList<PaySlip> paySlips;
	private List<TaxBracket> taxBrackets;
	private TestServiceLayer testServiceLayer;
	
	public TestController( ArrayList<Employee> employees ) {
		this.employees = employees;
		this.paySlips = new ArrayList<PaySlip>();
		this.readTaxBracketData();
		this.generatePaySlips();
	}
	
	private void generatePaySlips() {
		for ( Employee employee : this.employees ) {
			this.testServiceLayer = new TestServiceLayer( employee, this.prevTax, this.taxBracket );
			this.testServiceLayer.createPaySlip();
			this.paySlips.add( this.testServiceLayer.getPaySlip() );
		}
	}
	
	private void readTaxBracketData() {
		try {
			TypeReference<List<TaxBracket>> typeReference = new TypeReference<List<TaxBracket>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream( TAX_FILE );
			
			this.taxBrackets = new ObjectMapper().readValue( inputStream, typeReference );
			
			assert ( this.taxBrackets != null && !this.taxBrackets.isEmpty() ) : "Could not read tax brackets";
			
			for ( TaxBracket taxBracket : this.taxBrackets ) {
				this.prevTax.put( taxBracket.getIncome() , taxBracket.getPreviousTax() );
				this.taxBracket.put( taxBracket.getIncome() , taxBracket.getTaxRate() );
			}
			
		} catch (Exception ex) {
			System.out.println( "Unable to read data" );
		}
	}
	
	public ArrayList<PaySlip> getPaySlips() {
		return this.paySlips;
	}
	
}
