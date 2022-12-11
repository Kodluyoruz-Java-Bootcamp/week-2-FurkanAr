package medium.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import medium.model.Blog;
import medium.model.Status;
import medium.model.Tag;
import medium.model.User;

public class BlogDao {
	// List of all blogs
	private static List<Blog> blogList = new ArrayList<>();
	// List of all task
	private static List<Blog> taskList = new ArrayList<>();

	// Singleton pattern
	private static BlogDao blogDao = new BlogDao();
	
	private BlogDao(){}
	
	public static BlogDao getInstance() {
		return blogDao;
	}
	// Creates a new blog
	public Blog createBlog(Long no, String title, String content, String image, User user, Tag tag) {
		Blog blog = new Blog();
		blog.setNo(no);
		blog.setTitle(title);
		blog.setContent(content);
		blog.setImage(image);
		blog.setPublishedDate(LocalDateTime.now());
		blog.setStatus(Status.ACTIVE);
		blog.setUser(user);
		blog.setTag(tag);
		blogList.add(blog);
		return blog;
	}
	// Returns all blogs
	public List<Blog> getAllBlog(){
		return blogList;
	}
	// Finds blog by id
	public Blog findById(Long id) {		
		for(Blog blog: getAllBlog()) {
			if(	blog.getNo().equals(id))
				return blog;
		}
		return null;
	}
	// Deletes blog by id
	public Boolean deleteById(Long id) {
		Blog blog = findById(id);
		if(blog==null){
			return false;
		}
		return blogList.remove(blog);
	}
	// Creates a new task and save it
	public Blog saveBlog(User user) {
		Blog task = new Blog();
		task.setUser(user);
		taskList.add(task);
		return task;
	}
	
	// Returns all tasks
	public List<Blog> getAllTask(){
		return taskList;
	}
}
