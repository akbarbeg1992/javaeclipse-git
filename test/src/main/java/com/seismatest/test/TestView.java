package com.seismatest.test;

import com.seismatest.test.Employee;
import com.seismatest.test.PaySlip;
import com.seismatest.test.TestController;

public class TestView {
	Employee employee = new Employee( "Mirza", "Beg", 60050, 0.09f, 1 );
	
	TestController testController = new TestController( employee );
	
	PaySlip paySlip = testController.getPaySlip();
	
	
	
	Employee employee1 = new Employee( "F", "T", 120000, 0.10f, 1 );
	
	TestController testController1 = new TestController( employee1 );
	
	PaySlip paySlip1 = testController1.getPaySlip();
	
}
