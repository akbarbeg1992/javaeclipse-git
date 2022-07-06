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
	private List<TaxBracket> taxBracketsFromJson;
	private List<TaxBracket> taxBrackets;
	//private TestServiceLayer testServiceLayer;
	private TestServiceLayerNew testServiceLayerNew;
	
	public TestController( ArrayList<Employee> employees ) {
		this.employees = employees;
		this.taxBrackets = new ArrayList<TaxBracket>();
		this.paySlips = new ArrayList<PaySlip>();
		this.readTaxBracketData();
		this.generatePaySlips();
	}
	
	private void generatePaySlips() {
		for ( Employee employee : this.employees ) {
			//this.testServiceLayer = new TestServiceLayer( employee, this.prevTax, this.taxBracket );
			//this.testServiceLayer.createPaySlip();
			//this.paySlips.add( this.testServiceLayer.getPaySlip() );
			this.testServiceLayerNew = new TestServiceLayerNew( this.taxBrackets, employee );
			this.testServiceLayerNew.createPaySlip();
			this.paySlips.add( this.testServiceLayerNew.getPaySlip() );
			
		}
	}
	
	private void readTaxBracketData() {
		try {
			TypeReference<List<TaxBracket>> typeReference = new TypeReference<List<TaxBracket>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream( TAX_FILE );
			
			this.taxBracketsFromJson = new ObjectMapper().readValue( inputStream, typeReference );
			
			assert ( this.taxBracketsFromJson != null && !this.taxBracketsFromJson.isEmpty() ) : "Could not read tax brackets";
			
			for ( TaxBracket taxBracket : this.taxBracketsFromJson ) {
				this.taxBrackets.add( 0, taxBracket );
				this.prevTax.put( taxBracket.getTaxThreshold() , taxBracket.getPreviousTax() );
				this.taxBracket.put( taxBracket.getTaxThreshold() , taxBracket.getTaxRate() );
			}
			
		} catch (Exception ex) {
			System.out.println( "Unable to read data" + ex.getStackTrace() + ex.getMessage() + ex.getCause() );
		}
	}
	
	public ArrayList<PaySlip> getPaySlips() {
		return this.paySlips;
	}
	
}
