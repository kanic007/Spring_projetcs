package com.example.demo.service;


import java.util.*;
import com.example.demo.model.*;
public class BookService {
	
	
	private static BookService instance = new BookService();
	private static HashSet<Book>  books;

	private BookService() {
		books = new HashSet<>();
		books.add(new Book(101, "head frist java",450,"kathy sieera"));
	}

	public static BookService getInstance() {
	return instance;
	}

	public List<Book>  getAll() {
		return new ArrayList<>(books);
		}


	public boolean add(Book entity) {
		return books.add(entity);
	}

//	
//	public boolean updateById(int id,Book entity) {
//		return books.add(entity);
//	}
	
	
	public void updateById(int id, Book book) {
		Iterator <Book> itr = books.iterator();
		boolean found=false;
		
		Book elementToUpdate=null;
		while(itr.hasNext()) {
		   Book currentElement = itr.next();
			
			if(currentElement.getId()==id) {
			 found = true;
			
			 elementToUpdate=currentElement;
			}
			
		}
			if(found) {
				elementToUpdate.setAuthor(book.getAuthor());
				elementToUpdate.setBookName(book.getBookName());
				elementToUpdate.setPrice(book.getPrice());
			
			}else{
				throw new RuntimeException("Element Not Found");
			}
			
		

	}	public Book findById(int id) {
		
		Iterator <Book> itr = books.iterator();
		Book found = null;
		
		while(itr.hasNext()) {
			Book currentElement = itr.next();
			
			if(currentElement.getId()==id) {
				found = currentElement;
			}
			
		}
		
		return found;
	}
	
	
public void removeById(int id) {
		
		Iterator <Book> itr = books.iterator();
		boolean found=false;
		
		Book elementToDelete=null;
		while(itr.hasNext()) {
		   Book currentElement = itr.next();
			
			if(currentElement.getId()==id) {
			 found = true;
			
			 elementToDelete=currentElement;
			}
			
		}
			if(found) {
			books.remove(elementToDelete);
			
			}else{
				throw new RuntimeException("Element Not Found");
			}

	}
	


}
