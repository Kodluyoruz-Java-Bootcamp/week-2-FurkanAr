package medium;


import medium.model.Blog;
import medium.model.Tag;
import medium.model.User;
import medium.service.BlogService;
import medium.service.FollowerService;
import medium.service.TagService;
import medium.service.UserService;

public class Main {

	public static void main(String[] args) {
		UserService userService = UserService.getInstance();
		TagService tagService = TagService.getInstance();
		FollowerService followerService = FollowerService.getInstance();
		BlogService blogService = BlogService.getInstance();

		User userCem = userService.createUser("Cem", "cem@gmail.com", "cem12345");
		User userSami = userService.createUser("Sami", "Sami@gmail.com", "Sami12345");
		User userPelin = userService.createUser("Pelin", "pelin@gmail.com", "pelin123789");
		
		userService.printAllUser();
		/* Output
		User: User [name=Cem, mail=cem@gmail.com]
		User: User [name=Sami, mail=Sami@gmail.com]
		User: User [name=Pelin, mail=pelin@gmail.com]
		 */

		System.out.println("-----------");
		
		Tag programming = tagService.createTag("Programming");
		Tag writing = tagService.createTag("Writing");
		Tag technology = tagService.createTag("Technology");
		
		tagService.printAllTag();
		/* Output
		Tag: name= Programming
		Tag: name= Writing
		Tag: name= Technology
		 */
		System.out.println("-----------");
		
		tagService.followTag(userPelin, writing);
		tagService.followTag(userSami, technology);
		tagService.followTag(userCem, programming);
		tagService.followTag(userCem, technology);
		
		System.out.println(userCem.getName()+ " "+
				tagService.getFollowingTagByUser(userCem));
		
		/* Output
		 Cem [name= Programming, name= Technology]
		 */
		
		System.out.println("-----------");

		Blog blogCem = blogService.createBlog(101L,"OOP Concept", "OOP Concept in Java",
				"java.jpg", userCem, programming);

		Blog blogPelin =blogService.createBlog(102L,"Inheritance in Java", "Inheritance Concept in Java", 
				"java2.jpg", userPelin, programming);
		
		Blog blogPelin2 =blogService.createBlog(103L,"Polymorphism in Java", "Polymorphism Concept in Java", 
				"java3.jpg", userPelin, programming);
		
		Blog blogPelin3 =blogService.createBlog(104L,"Road Trip", "A long way to Istanbul", 
				"istanbul.jpg", userPelin, writing);
		
		blogService.printAllBlog();
		
		/* Output
		Blogs: Blog [no=101, title=OOP Concept, content=OOP Concept in Java, image=java.jpg, publishedDate=2022-12-10T02:43:50.177273800, user=Cem, status=ACTIVE, tag=name= Programming]
		Blogs: Blog [no=102, title=Inheritance in Java, content=Inheritance Concept in Java, image=java2.jpg, publishedDate=2022-12-10T02:43:50.178269300, user=Pelin, status=ACTIVE, tag=name= Programming]
		Blogs: Blog [no=103, title=Polymorphism in Java, content=Polymorphism Concept in Java, image=java3.jpg, publishedDate=2022-12-10T02:43:50.178269300, user=Pelin, status=ACTIVE, tag=name= Programming]
		Blogs: Blog [no=104, title=Road Trip, content=A long way to Istanbul, image=istanbul.jpg, publishedDate=2022-12-10T02:43:50.178269300, user=Pelin, status=ACTIVE, tag=name= Writing]
		 */
		
		System.out.println("-----------");

		Blog taskSami =blogService.createTask(userSami);
		Blog taskPelin =blogService.createTask(userPelin);

		blogService.printAllTask();

		/* Output
		Task: Blog [no=null, title=null, content=null, image=null, publishedDate=null, user=Sami, status=null, tag=null]
		Task: Blog [no=null, title=null, content=null, image=null, publishedDate=null, user=Pelin, status=null, tag=null]
		*/
		
		System.out.println("-----------");
		
		System.out.println(blogService.deleteBlog(101L));
		// Blog number 101 has been deleted

		System.out.println("-----------");
		
		blogService.printAllBlog();
		
		/* Output
		Blogs: Blog [no=102, title=Inheritance in Java, content=Inheritance Concept in Java, image=java2.jpg, publishedDate=2022-12-10T02:45:34.751829100, user=Pelin, status=ACTIVE, tag=name= Programming]
		Blogs: Blog [no=103, title=Polymorphism in Java, content=Polymorphism Concept in Java, image=java3.jpg, publishedDate=2022-12-10T02:45:34.751829100, user=Pelin, status=ACTIVE, tag=name= Programming]
		Blogs: Blog [no=104, title=Road Trip, content=A long way to Istanbul, image=istanbul.jpg, publishedDate=2022-12-10T02:45:34.751829100, user=Pelin, status=ACTIVE, tag=name= Writing]
		 */
		
		System.out.println("-----------");
		
		blogService.getByUser(userPelin);
		/* Output
		Writer: Pelin Blog [no=102, title=Inheritance in Java, content=Inheritance Concept in Java, image=java2.jpg, publishedDate=2022-12-10T02:45:34.751829100, user=Pelin, status=ACTIVE, tag=name= Programming]
		Writer: Pelin Blog [no=103, title=Polymorphism in Java, content=Polymorphism Concept in Java, image=java3.jpg, publishedDate=2022-12-10T02:45:34.751829100, user=Pelin, status=ACTIVE, tag=name= Programming]
		Writer: Pelin Blog [no=104, title=Road Trip, content=A long way to Istanbul, image=istanbul.jpg, publishedDate=2022-12-10T02:45:34.751829100, user=Pelin, status=ACTIVE, tag=name= Writing]
		
		*/
		System.out.println("-----------");

		followerService.follow(userCem, userPelin);
		followerService.follow(userCem, userSami);	
		followerService.follow(userCem, userCem);	

		followerService.getFollows(userCem);
		/* Output
	 	Cem follows: Pelin
		Cem follows: Sami
		 */

		System.out.println("-----------");

		followerService.follow(userPelin, userCem);
		followerService.follow(userPelin, userSami);
		followerService.getFollows(userPelin);

		/* Output
		Pelin follows: Cem
		Pelin follows: Sami
		 */

	}

}
