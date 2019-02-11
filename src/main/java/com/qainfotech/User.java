package com.qainfotech;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement (name="user")
public class User {
	public User() {}
	private String name, email;
	private String password;
	
	private List<String> comment = new ArrayList<String>();

	public List<String> getComments() {
		return comment;
	}

	public void setComments(List<String> comments) {
		this.comment = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return email+"::"+name;
	}

}
