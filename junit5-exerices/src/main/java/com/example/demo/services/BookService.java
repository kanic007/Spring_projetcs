package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.example.demo.Book;

public class BookService  {
	
	static int count =0;
	
	public double getDiscount(Book book)  throws RuntimeException {
		
		
		
		boolean status =true;
		double discount =0.05;
		
		while(status) {
		
			if(book.getPrice() <200) {
				discount =0.10;
			} else if(book.getPrice() >200 && book.getPrice() <= 500) {
				discount =0.15;
			}
		count++;
		
		if(count>100)
			status =false;
		}
		
		return discount;
	}
	
	public Book getBook(int key)  {
		
		if(key>0) {
		switch (key) {
		case 1:
			
			return new Book(100,"java",120);
			
        case 2:
			
			return new Book(101,"spring",200);
			
        case 3:
			
			return new Book(102,"react",800);

		default:
			break;
		}
		
		}else {
			throw new RuntimeException();
		}
		return null;
	}
	
	public List<Book> getAllBooks() {
		   
		Book java = new Book(100,"java",120);
		Book sql = new Book(101,"sql",120);
		Book C = new Book(102,"python",120);
		Book python = new Book(103,"python",120);
		Book html = new Book(104,"html",120);
		
	     ArrayList<Book> list = new ArrayList();
	     
	     
	     list.add(java);
	     list.add(sql);
	     list.add(C);
	     list.add(python);
	     list.add(html);
		return list;
	     

	
	       
	     }


}
