package com.junit.rules;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorRule {
	
	
	@Rule	
	public ErrorCollector collector = new ErrorCollector();

	
	@Test
	public void accumulateErrors(){
		
		try{
			int i= 10/0;
		}catch(Exception e){
			e.printStackTrace();			
			collector.addError(new Throwable("Divide by Zero"));
		}
		
		System.out.println("First Between");
		assertTrue(1==1);
		
		try{
			int[] j= {1, 2,3 };
			int i = j[4];
		}catch(Exception e){
			collector.addError(new Throwable("ArrayIndexOutofBounds"));
		}
		System.out.println("Second Between");
		assertTrue(2==2);	
		
		
		
	}
	
	
}
