package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.ifaces.CurrencyConverter;

@Service
public class CurrencyConverterService implements CurrencyConverter{

	@Override
	public double inrToUsd(double amount) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		   e.printStackTrace();
		}
		
		return amount*80;
	}

	@Override
	public double inrToEuro(double amount) {
	
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
		return amount*90;
	}

	 
}
