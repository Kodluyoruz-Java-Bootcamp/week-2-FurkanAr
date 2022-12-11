package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.Search;
import emlakcepte.model.User;

public class SearchDao {
	// All searches
	private static List<Search> searchList = new ArrayList<>();
	
	//Singleton Pattern
	private static SearchDao searchDao = new SearchDao();
	
	private SearchDao() {}
	
	public static SearchDao getInstance() {
		return searchDao;
	}
	
	// Create a search and save
	public void saveSearch(User user, String item) {
		Search search = new Search();
		search.setUser(user);
		search.setPlaceHolder(item);
		searchList.add(search);
	}
	// Get all search
	public List<Search> findAll(){
		return searchList;
	}
}
