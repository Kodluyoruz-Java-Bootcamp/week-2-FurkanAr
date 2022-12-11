package medium.service;

import java.util.List;

import org.springframework.stereotype.Service;

import medium.dao.BlogDao;
import medium.model.Blog;
import medium.model.Tag;
import medium.model.User;

@Service
public class BlogService {
	// Singleton Pattern	
	private BlogDao blogDao = BlogDao.getInstance();
	
	private static BlogService blogService = new BlogService();
	
	private BlogService() {}
	
	public static BlogService getInstance() {
		return blogService;
	}
	// Acts as an intermediary to create blog information
	public Blog createBlog(Long no, String title, String content, String image, User user, Tag tag) {
		return blogDao.createBlog(no,title,content,image,user,tag);
	}
	// Returns all blogs
	public List<Blog> getAllBlog(){
		return blogDao.getAllBlog();
	}
	// Prints blogs
	public void printAllBlog() {
		getAllBlog().forEach(blog -> System.out.println("Blogs: " +blog));
	}
	// Prints blogs by user
	public void getByUser(User user){
		getAllBlog().stream()
		.filter(blog -> blog.getUser().equals(user))
		.forEach(blog -> System.out.println(
				"Writer: "+ user.getName() + " " + blog));
	}
	// Acts as an intermediary to delete blog 
	public String deleteBlog(Long id) {
		if(blogDao.deleteById(id) == true)
			return "Blog number " +id+ " has been deleted";
		return "Blog number " +id+ " doesnt exist";
	}
	// Acts as an intermediary to create a new task
	public Blog createTask(User user) {
		return blogDao.saveBlog(user);
	}
	// Returns all tasks
	public List<Blog> getAllTask(){
		return blogDao.getAllTask();
	}
	
	
	public void printAllTask() {
		getAllTask().forEach(task -> System.out.println("Task: " +task));
	}

}
