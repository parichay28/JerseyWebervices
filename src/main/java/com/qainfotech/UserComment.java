package com.qainfotech;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "addcomment")
public class UserComment{
	
	private String email, comment;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
