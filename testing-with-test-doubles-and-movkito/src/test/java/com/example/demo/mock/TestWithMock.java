package com.example.demo.mock;

import org.junit.jupiter.api.Test;

import com.example.demo.mock.MockInvoiceRepository;

public class TestWithMock {

	@Test
	public void testAdd() {

		MockInvoiceRepository mock = new MockInvoiceRepository();

		InvoiceService service = new InvoiceService(mock);

		Invoice inv1 = new Invoice(901, "tom", 4848);
		Invoice inv2=new Invoice(902, "jerry", 5600);

		service.addInvoice(inv1);
		service.addInvoice(inv2);

		    mock.verify(inv2, 2);
		}


	
}
