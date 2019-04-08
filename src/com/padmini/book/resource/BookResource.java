package com.padmini.book.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.padmini.book.database.BookDao;
import com.padmini.book.model.BookInfo;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
	
	BookDao bd = new BookDao();
	
	@POST
	public BookInfo addBooks(@PathParam("username") String username, BookInfo book)
	{
		
		return bd.addBook(book, username);
	}
	
	@GET
	public List<BookInfo> getAllBooks(@PathParam("username") String username)
	{
		
		return bd.getAllBooks(username);
	}
	
	@PUT
	public BookInfo updateBook(@PathParam("username") String username, BookInfo book)
	{
		
		return bd.upateBook(book, username);
	}
	
	@DELETE
	public String deleteBook(@PathParam("username") String username, BookInfo book)
	{
		return (bd.deleteBook(book, username)).getBook_name();
		 
	}
}
