package medium.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import medium.model.User;

public class UserDao  {
	// List of all user
	private  List<User> userList = new ArrayList<>();

	// Singleton pattern
	private static UserDao userDao = new UserDao();
	
	private UserDao() {}
	
	public static UserDao getInstance() {
		return userDao;
	}
	// Creates a new user
	public User createUser(String name, String mail, String password) {
		User user = new User();
		user.setName(name);
		user.setMail(mail);
		user.setPassword(password);
		user.setCreateDate(LocalDateTime.now());
		user.setBlogList(Collections.emptyList());
		user.setFollowerList(Collections.emptyList());
		user.setTagList(Collections.emptyList());
		userList.add(user);
		return user;
	}
	// Returns users
	public List<User> getAllUsers(){
		return userList;
	}

}
