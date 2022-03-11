package com.example.demo.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInvoiceServiceWithStub {

	@DisplayName("Test findAll Returns All Elements from the collection")
	@Test
	void testForAdd() {
		InvoiceRepository invRepo= new InvoiceRepositoryStub();
				
		InvoiceService service= new InvoiceService(invRepo);
		


		int actual= service.findAll().size();
		int expected=2;
		assertEquals(expected,actual);
		

	}
	
	
	
}
