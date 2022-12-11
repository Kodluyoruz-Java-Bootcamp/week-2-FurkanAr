package emlakcepte.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

public class UserDao {
	
	private static List<User> userList = new ArrayList<>();
	
	// Singleton pattern
	private static UserDao userDao = new UserDao();
	
	private UserDao() {}
	
	public static UserDao getInstance() {
		return userDao;
	}
	
	// Create a user and save 
	public User createUser(String name, String mail, String password, UserType type) {
		User user = new User();
		user.setName(name);
		user.setMail(mail);
		user.setPassword(password);
		user.setType(type);
		user.setCreateDate(LocalDateTime.now());
		user.setFavoriteRealtyList(Collections.emptyList());
		user.setMessages(Collections.emptyList());
		user.setRealtyList(Collections.emptyList());
		userList.add(user);
		return user;
	}
	// Get all user
	public List<User> findAllUsers() {	
		return userList;
	}



}
