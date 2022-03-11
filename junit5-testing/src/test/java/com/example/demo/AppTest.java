 	package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
 
	
	 Greeting grtObj;
//    @BeforeAll
//    public static void init() {
//   	 
//    	System.out.println("Before All Called");
//    	//grtObj = new Greeting();
//    	
//    }
    
//    @BeforeEach
//    public  void startUp() {
//      	 
//    	System.out.println("Before Each Called=====");
//    	grtObj = new Greeting();
//    	
//    }
   static CurrencyConverter CryObj;
  
	 @BeforeAll  
	 public static void init() {
		 
		System.out.println("Before All Called");
		CryObj = new CurrencyConverter();
		
	}
   
   
    
    @Test
    public  void testusdToInrMethodNotNegative() {
     
    	double actual = CryObj.usdToInr(50.0);
    	
    	assertTrue( actual>0 );		
   
    }
    
    @Test
    public  void testusdToInrMethodReturnsEquals() {
     
    	double actual = CryObj.usdToInr(50);
    	
    	double expected =5000;
    	
    	assertEquals(expected, actual);	
   
    }
    
    
  
    
//    @Test
//    public void testGreetMethodReturnsNull() {
//    	 
//    	Greeting grtObj = new Greeting();
//    	String actual = grtObj.getMessage();
//    	
//    	 assertNull( actual );
//    
//    }
//    
//    @Test
//    public void testGreetMethodReturnsNotNull() {
//    	 
//    	Greeting grtObj = new Greeting();
//    	String actual = grtObj.getMessage();
//    	
//    	 assertNotNull( actual );
//    
//    }
//    
//    @Test
//    @DisplayName(value = "To Test The method return a String  with Hello")
//    public void testGreetMethodReturnsString() {
//    	 
//    	Greeting grtObj = new Greeting();
//    	String actual = grtObj.getMessage();
//    	
//    	 assertNotNull( actual );
//    
//    }
    
}
