package emlakcepte.service;

import java.util.List;

import org.springframework.stereotype.Service;

import emlakcepte.dao.SearchDao;
import emlakcepte.model.Search;
import emlakcepte.model.User;

@Service
public class SearchService {
	
	// Singleton pattern
	private SearchDao searchDao = SearchDao.getInstance();
	
	private static SearchService searchService = new SearchService();
	
	private SearchService() {}
	
	public static SearchService getInstance() {
		return searchService;
	}
	
	public void createSearch(User user,String search) {
		searchDao.saveSearch(user, search);

	}

	public List<Search> getAll(){
		return searchDao.findAll();
	}
	
	public void printAll(List<Search> searchList) {
		searchList.forEach(search -> System.out.println
				("Search: " +search.getUser().getName() + ": "+ search.getPlaceHolder()));
	}
	
	public List<Search> getAllByUserName(User user){	
		return getAll().stream()
		.filter(search -> search.getUser().getName().equals(user.getName()))
		.toList();		
	}
}
