package medium.service;

import java.util.List;

import org.springframework.stereotype.Service;

import medium.dao.UserDao;
import medium.model.User;

@Service
public class UserService {

	// Singleton Pattern	
	private UserDao userDao = UserDao.getInstance();

	private static UserService userService = new UserService();
	
	private UserService() {
	}
	
	public static UserService getInstance() {
		return userService;
	}
	// Acts as an intermediary to create new user information
	// Check password operation
	public User createUser(String name, String mail, String password) {
		try {
			if(password.length() < 5) {
				System.out.println(name +" your password is too short try again");
			}else
				return userDao.createUser(name, mail, password);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// Returns users in system
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return userDao.getAllUsers();
	}
	// Prints users in system
	public void printAllUser() {	
		getAllUser().forEach(user -> System.out.println("User: "+user));
	}






	

	

}
