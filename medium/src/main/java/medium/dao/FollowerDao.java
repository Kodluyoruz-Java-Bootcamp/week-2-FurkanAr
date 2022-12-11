package medium.dao;

import java.util.ArrayList;
import java.util.List;

import medium.model.User;

public class FollowerDao {
	
	// Singleton pattern
	private static FollowerDao followerDao = new FollowerDao();
	
	private FollowerDao() {}
	
	public static FollowerDao getInstance() {
		return followerDao;
	}
	// Follows a new user
	public void follow(User userFrom, User userTo) {
		if(!userFrom.getFollowList().contains(userTo) && !userFrom.equals(userTo))
			addList(userFrom, userTo);
	}
	// Add follower to user follow list
	public void addList(User userFrom, User userTo) {
		List<User> list =userFrom.getFollowList();
        List<User> users = new ArrayList<>(list);
        users.add(userTo);
		userFrom.setFollowerList(users);
	}
	// Returns follow list
	public List<User> getFollow(User user){
		return user.getFollowList();
	}
	
}
