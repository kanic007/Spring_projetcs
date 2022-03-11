package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.demo.services.BookService;

public class BookServiceTest {

	private BookService service;
	
	@BeforeAll
	public static void init() {
		 
//		System.out.println("BEFORE ALL called");
		
		
	 }
	@BeforeEach
	public void setup() {
		 
//		System.out.println("BEFORE EACH called");
		
		service = new BookService();
		
	 }
	
	
	
	@Test
	@DisplayName( "should not return null values for choices  1 to 3")
	 public void testGetBookMethodNotNull() {
		 
		//System.out.println("Dummy Test 1 called");
		
//		Book actual = service.getBook(2);
//		assertNotNull(actual);
		
		
		assertAll("getBook Method with choice 1 to 3",
	              () -> assertNotNull(service.getBook(1)),
	              () -> assertNotNull(service.getBook(2)),
	              () -> assertNotNull(service.getBook(3))

				
				);
		
	 }
	
	
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	
	void testGetBookMethodWithParam(int key) {
		
		assertNotNull(service.getBook(key));
	}
	
	
	@Test
	@DisplayName( " should return null values for choices above 4")

	void testGetBookMethodReturnNull() {
		
		assertNull(service.getBook(4));
	}
	
	
	@Test
	void testforException() {
		
		Throwable exception = assertThrows(RuntimeException.class, () -> {
			service.getBook(-2);
			
		});
		
	}
	
	@Test
	@DisplayName( " getDiscount method should return 0.10 discount for price less than or equal to 200")
	void testFortenpercentDiscount() {
		
		Book book = service.getBook(1);
		double actual = service.getDiscount(book);
		double expected =0.10;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	@DisplayName( " getDiscount method should return 0.05 discount for price less than or equal to 200")
    @Disabled("Disable till timout bug in method if fixed")
	void testGetBookTestFivePercentDiscount() {
		
		Book book = service.getBook(1);
		double actual = service.getDiscount(book);
		double expected =0.05;
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	@DisplayName( " getDiscount method should be completed with 100ms")
	void testGetBookcompletetionTiming() {
		
		
		Book book = service.getBook(3);
		double actual = service.getDiscount(book);
		double expected =0.15;
		
		double value = assertTimeout(Duration.ofMillis(100), ()-> service.getDiscount(book));
		
		assertEquals(expected, actual);
		
		
		
	}
	
	@ParameterizedTest
    @DisplayName( "GetAllBooks method should return a List with index position 1,3,5 not being null")
	@ValueSource(ints = {1,3,4})
    void testGetAllBooksPostion(int key) {
		List<Book> actual = service.getAllBooks();
		
		assertNotNull(actual.get(key));

//		assertFalse(true,"Not Yet Implemented");
	}
	
	
	
	
	

	
	@AfterAll
	public  static void destory() {
		 
//		System.out.println("AFTER ALL called");
		
		
	 }
	@AfterEach
	public void tearDown() {
		 
//		System.out.println("AFTER EACH called");
		
		
	 }
	
	
}
