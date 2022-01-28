package com.flipkart.stepdefinition;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;



public class TestRunner {
	
	public static void main(String[] args) {

	Result rs=JUnitCore.runClasses(MobilePurchase.class,TVPurchase.class);
	
	System.out.println("Total Methods:"+rs.getRunCount());
	System.out.println("Total Time:"+rs.getRunTime());
	System.out.println("Total Failure:"+rs.getFailureCount());
	System.out.println("Total Ignore:"+rs.getIgnoreCount());
	
	List<Failure>fail=rs.getFailures();
	for(Failure x:fail) {
		System.out.println(x);
		System.out.println(x.getMessage());
		
	}
	
	}	
}
