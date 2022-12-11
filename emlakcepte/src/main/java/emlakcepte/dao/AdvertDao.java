package emlakcepte.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import emlakcepte.model.Advert;
import emlakcepte.model.Realty;

public class AdvertDao {
	
	// List of city adverts 
	private static List<Advert> advertList = new ArrayList<>();
	
	// Singleton pattern
	private static AdvertDao advertDao = new AdvertDao();
	
	private AdvertDao() {}
	
	public static AdvertDao getInstance() {
		return advertDao;
	}
	
	// Create adverts for cities
	public void createAdvert(String province, List<Realty> realty) {
		Advert advert = new Advert();
		advert.setName(province);
		advert.setAdvertList(Collections.emptyList());
		addList(advert, realty);
		advertList.add(advert);
	}
	
	// Sets the city with a city advert
	public void addList(Advert advert, List<Realty> realty) {
		List<Realty> list = advert.getAdvertList();
		List<Realty> adverts = new ArrayList<>(list);
		realty.stream().forEach(r-> adverts.add(r));
		advert.setAdvertList(adverts);
	}
	
	// Brings all city adverts
	public List<Advert> getAdvert(){
		return advertList;
	}
}
