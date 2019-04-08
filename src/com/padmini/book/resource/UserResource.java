package com.padmini.book.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.padmini.book.database.UserDao;
import com.padmini.book.model.UserInfo;



@Path("user")
public class UserResource {
	UserDao ud = new UserDao();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	 public String addUser(UserInfo user)
	 {	
		
		UserInfo uf = ud.addUser(user);		
		return user.getUname()+" registered !";
	 }

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@QueryParam("name") String name, @QueryParam("pass") String password)
	{
		UserInfo uf = ud.getUser(name);
		if(uf.getUname().equals(name) && uf.getPassword().equals(password))
		  return "t";
		//	return uf;
		else
			return "f";
		//	return uf;
	}
	
	@Path("/{username}/books")
	public BookResource getBookResource()
	{
		
	 return new BookResource();
	}

	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getAllUssers()
	{
			return ud.getAllUsers();
	}
*/	
	
}
