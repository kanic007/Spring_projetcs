package com.example.demo.stub;

import java.util.Arrays;
import java.util.Collection;

import com.example.demo.stub.Invoice;
import com.example.demo.stub.InvoiceRepository;

public class InvoiceRepositoryStub implements InvoiceRepository {

	@Override
	public int add(Invoice entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Invoice> findAll() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Invoice(101,"kanic",100),new Invoice(102,"selva",101));
	}

}
