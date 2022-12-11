package medium.service;

import medium.dao.FollowerDao;
import medium.model.User;

public class FollowerService {
	// Singleton pattern
	private FollowerDao followerDao = FollowerDao.getInstance();
	
	private static FollowerService followerService = new FollowerService();
	
	private FollowerService() {}
	
	public static FollowerService getInstance() {
		return followerService;
	}
	// Acts as an intermediary to create follow information
	public void follow(User userFrom, User userTo) {
		followerDao.follow(userFrom, userTo);
	}
	// Prints follows list
	public void getFollows(User user){
		followerDao.getFollow(user)
		.forEach(u -> System.out.println
				(user.getName() +" follows: " +u.getName()));
	}
	
}
