package medium.service;

import java.util.List;

import org.springframework.stereotype.Service;

import medium.dao.TagDao;
import medium.model.Tag;
import medium.model.User;

@Service
public class TagService {
	// Singleton pattern
	private TagDao tagDao = TagDao.getInstance();
	
	private static TagService tagService = new TagService();
	
	private TagService() {}
	
	public static TagService getInstance() {
		return tagService;
	}
	// Acts as an intermediary to create tag information
	public Tag createTag(String name) {
		return tagDao.createTag(name);
	}
	// Returns taglist
	public List<Tag> getAllTag(){
		return tagDao.getAllTag();
	}
	// Prints all tags
	public void printAllTag() {
		getAllTag().forEach(tag -> System.out.println("Tag: "+tag));
	}
	//Acts as an intermediary to save follow a tag information
	public void followTag(User user, Tag tag) {
		tagDao.followTag(user, tag);
	}
	// Returns following tags by user
	public List<Tag> getFollowingTagByUser(User user){
		return tagDao.getTagByUser(user);
	}
	

}
