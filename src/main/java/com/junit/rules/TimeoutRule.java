package com.junit.rules;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class TimeoutRule {
	
	@Rule
	public TestRule globalTimeout = new Timeout(10, TimeUnit.SECONDS);
	
	// TimeOut(int) - deprecated
	
	public static String log; 
	
	//Infinite loop - so fails due to time out exception
	
	@Test
	public void test1(){
		log += "ran1";
		for(;;){}
	}
	
	@Test
	public void test2(){
		for(int i=0; i<10; i++){
			System.out.println("Hello");
		}
	}

}
