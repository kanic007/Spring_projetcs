package com.example.demo.resource;



import java.util.List;



import com.example.demo.model.Book;
import com.example.demo.service.BookService;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rest")
public class BookResource {

	BookService service = BookService.getInstance();
	
	
	@GET
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBookList(){
		return service.getAll();
	}
	

	@GET
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("id")int id){
		return service.findById(id);
	}
	
	
	@DELETE
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeBookById(@PathParam("id")int id){
		 service.removeById(id);
		 
		 return Response.status(204).entity("Removed").build();
	}
	
	
	@PUT
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBookById(@PathParam("id")int id, Book book){
		
		try {
		service.updateById(id,book);
		 return Response.status(200).entity(book).build();
		}
		catch(RuntimeException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@POST
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBook(Book entity) {
		
		boolean result =service.add(entity);
		
		if(result) {
			return Response.status(201).entity(entity).build();
		}else {
			return Response.status(200).entity("Not Created").build();
		}

	}
	
	
	
	
}
