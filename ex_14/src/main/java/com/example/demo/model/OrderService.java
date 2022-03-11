package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.ToString;



	@ToString
	@Component
	public class OrderService {
		private SalesOrder salesOrder;
	@Autowired
		public OrderService(SalesOrder salesOrder) {
			super();
			this.salesOrder = salesOrder;
		}
		
		
		public double findTotal() {
			
			this.salesOrder.getItemList();
			List<Item> itemList=salesOrder.getItemList();
			double total = 0;
			for (Item item : itemList) {
					double qty=item.getQuantity();
					double price=item.getRatePerUnit();
					double normal=qty*price;
					total=total+normal;
			}
			return total;
		}
	
	}

