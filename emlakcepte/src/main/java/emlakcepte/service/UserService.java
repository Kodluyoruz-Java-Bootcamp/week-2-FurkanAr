package emlakcepte.service;

import java.util.List;

import org.springframework.stereotype.Service;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;
import emlakcepte.model.UserType;

@Service
public class UserService{
		
	// Singleton Pattern	
	private UserDao userDao = UserDao.getInstance();

	private static UserService userService = new UserService();
	
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		return userService;
	}


	public User createUser(String name, String mail,String password, UserType type ) {		
		//UserDao userDao = new UserDao(); tekrar tekrar oluşturmamıza gerek yok
		//System.out.println("ben bir userDao objesiyim:" + userDao.toString());		
		try {
			if(password.length() < 5) {
				System.out.println(name +" your password is too short try again");
			}else
				return userDao.createUser(name, mail, password, type);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return userDao.findAllUsers();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println("User: "+user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		for(User u:getAllUser()) {
			if(u.equals(user)) {
				u.setPassword(newPassword);
			}
		}
	}

}
