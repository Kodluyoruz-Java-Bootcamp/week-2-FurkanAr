package emlakcepte.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import emlakcepte.factory.RealtyFactory;
import emlakcepte.model.Category;
import emlakcepte.model.Realty;
import emlakcepte.model.RealtyType;
import emlakcepte.model.User;

public class RealtyDao {
    private RealtyFactory realtyFactory = new RealtyFactory();  

	// List of realty
	private static List<Realty> realtyList = new ArrayList<>();

	//Singleton Pattern
	private static RealtyDao realtyDao = new RealtyDao();
	
	private RealtyDao() {}
	
	public static RealtyDao getInstance() {
		return realtyDao;
	}
	
	//Create a Realty with the help of RealFactory
	public Realty createRealty(String realtyType, Long no, String title, LocalDateTime time, User user, RealtyType status, String province, String district, Category category) {
		Realty realty = realtyFactory.getRealty(realtyType);
		realty.setNo(no);
		realty.setTitle(title);
		realty.setPublishedDate(time);
		realty.setUser(user);
		realty.setStatus(status);
		realty.setProvince(province);
		realty.setDistrict(district);
		realty.setCategory(category);
		realtyList.add(realty);
		
		if(!user.getRealtyList().contains(realty))
			addList(realty);
		return realty;
	}
	// Add realty to list
	public void addList(Realty realty) {
		List<Realty> list = realty.getUser().getRealtyList();
		List<Realty> realties = new ArrayList<>(list);
		realties.add(realty);
		realty.getUser().setRealtyList(realties);
	}
	// Get all realty
	public List<Realty> findAll(){
		return realtyList;
	}
}
