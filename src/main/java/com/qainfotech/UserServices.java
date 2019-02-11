package com.qainfotech;


public interface UserServices {
	
	public Reply userRegistration(User user);
	public Reply userLogin(UserLogin user);
	public Reply addComment(UserComment comment);
	public User showUserComments(String email);
	public User[] showAllComments();

}
