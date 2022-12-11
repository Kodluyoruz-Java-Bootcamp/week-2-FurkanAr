package emlakcepte.model;

public class Search {
	
	String placeHolder;
	User user;
	
	public Search() {
	}
	
	public Search(String placeHolder) {
		super();
		this.placeHolder = placeHolder;
	}
	
	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
