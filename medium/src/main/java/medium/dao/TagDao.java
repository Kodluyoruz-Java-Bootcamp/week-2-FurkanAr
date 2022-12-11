package medium.dao;

import java.util.ArrayList;
import java.util.List;

import medium.model.Tag;
import medium.model.User;

public class TagDao {
	// List of all tags
	private  List<Tag> tagList = new ArrayList<>();

	private static TagDao tagDao = new TagDao();
	
	private TagDao() {}
	
	public static TagDao getInstance() {
		return tagDao;
	}
	// Creates a new tag
	public Tag createTag(String name) {
		Tag tag = new Tag();
		tag.setName(name);
		tagList.add(tag);
		return tag;	
	}
	// Returns all tags
	public List<Tag> getAllTag(){
		return tagList;
	}
	// Follows the tag
	public void followTag(User user, Tag tag) {
		if(!user.getTagList().contains(tag)) 
			addTag(user,tag);
	}
	// Adds tag to user tag list
	public void addTag(User user, Tag tag) {
		List<Tag> list = user.getTagList();
		List<Tag> tags = new ArrayList<>(list);
		tags.add(tag);
		user.setTagList(tags);
	}
	// List of tag by user
	public List<Tag> getTagByUser(User user) {
		return user.getTagList();
	}
}
