package com.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptedException {

	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void testNullPointerException(){
		thrown.expect(NullPointerException.class);
		throw new NullPointerException();
	}
	
	// this test fails 
	
	@Test
	public void testNoException(){
		thrown.expect(ArrayIndexOutOfBoundsException.class);		
	}
	
	
}
