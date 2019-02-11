package com.qainfotech;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/userservices")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserServicesImpl implements UserServices {

	private static Map<String, User> userReg = new HashMap<String, User>();
	
	private static Map<String, UserLogin> loggedUsers = new HashMap<String, UserLogin>();
	//private static Map<String, String> userComments = new HashMap<String, String>();

	@POST
	@Path("/register")
	public Reply userRegistration(User user) {
		Reply response = new Reply();

		if (userReg.get(user.getEmail()) != null) {
			response.setStatus(false);
			response.setMessage("User Already Exists");
			return response;
		}
		
		userReg.put(user.getEmail(), user);
		response.setStatus(true);
		response.setMessage("Registration Successful");
		return response;
	}

	@POST
	@Path("/login")
	public Reply userLogin(UserLogin user) {
		Reply response = new Reply();

		if (userReg.get(user.getEmail()) != null
				&& userReg.get(user.getEmail()).getPassword().equals(user.getPassword())) {
			loggedUsers.put(user.getEmail(), user);
			response.setStatus(true);
			response.setMessage("User successfully logged in");
			return response;
		}

		response.setStatus(false);
		response.setMessage("Invalid Email or Password");
		return response;
	}

	@POST
	@Path("/addcomment")
	public Reply addComment(UserComment comment) {
		Reply response = new Reply();
		
		if (loggedUsers.get(comment.getEmail()) != null) {
			User user= userReg.get(comment.getEmail());
			List<String> commentList = user.getComments();
			commentList.add(comment.getComment());
			user.setComments(commentList);
			response.setStatus(true);
			response.setMessage("User comment added successfully");
			return response;
			
		}
		response.setStatus(false);
		response.setMessage("Please make sure that you are logged and the Email is correct");
		return response;

	}
	
	@GET
	@Path("/{email}/showusercomments")
	public User showUserComments(@PathParam("email") String email) {
		System.out.println(email);
		//email = "p@gmail.com";
		//Response response = new Response();
		User user = null;
		if (loggedUsers.get(email) != null) {
			System.out.println("here");
			user= userReg.get(email);
			//response.setStatus(true);
			//response.setMessage("User comment added successfully");
			//return response;
			return user;
			
		}
		//response.setStatus(false);
		//response.setMessage("Please make sure that you are logged and the Email is correct");
		//return response;
		return user;
	}
	
	@GET
	@Path("/showallcomments")
	public User[] showAllComments() {
        Set<String> emailSet = userReg.keySet();
        User[] users= new User[emailSet.size()];
        int curruser=0;
        for(String email: emailSet) {
        	users[curruser]=userReg.get(email);
        	curruser++;
        }
        return users;
	}

}
