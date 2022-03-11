package com.example.demo.fake;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class TestInvoiceServiceWithFake {

	
	
	@DisplayName("Test InvoiceService class addInvoice method should return 0 if no elment is prestent with the key else 1 if there is already an element")
	@Test
	void testForAddSuccess() {
		

				
		InvoiceRepository repo = new FakeInvoiceRepository();
		InvoiceService service = new InvoiceService(repo);

		Invoice invoice = new Invoice(101,"kanic", 499.00);
		

		int actual= service.addInvoice(invoice);
		int expected=1;
		assertEquals(actual,expected);
		
		
		
		
		
	}
	
	@DisplayName("Test InvoiceService class addInvoice method should return 0 if no elment is prestent with the key else 1 if there is already an element")
	@Test
	void testForAddSuccessCheck() {
		

				
		InvoiceRepository repo = new FakeInvoiceRepository();
		InvoiceService service = new InvoiceService(repo);

		Invoice invoice = new Invoice(101,"kanic", 499.00);
		
		Invoice invoice1 = new Invoice(102,"selva", 499.00);

		int actual= service.addInvoice(invoice);
		int expected=1;
		assertEquals(actual,expected);
		
	    int actual1= service.addInvoice(invoice1);
		
		assertEquals(actual1,expected);
		
		
		
		
	}
}
